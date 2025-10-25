package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.*;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.TradeRules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTradeRepository extends TradeRules implements TradeRepository {

    private final SpringDataTradeRepository repository;
    private final TradeMapper tradeMapper;
    private final Utils utils;

    public JpaTradeRepository(SpringDataTradeRepository repository,  TradeMapper tradeMapper, Utils utils){
        this.repository = repository;
        this.tradeMapper = tradeMapper;
        this.utils = utils;
    }

    @Override
    public void save(TradeToSave trade, Long id){
        List<TradeEntity> trades = repository.findByInitiator_IdOrPartner_Id(id, id);
        List<Trade> tradeArrayList = new ArrayList<>();
        boolean exist = false;
        if(!trades.isEmpty()){
            trades.forEach(t ->tradeArrayList.add(tradeMapper.tradeEntityToTrade(t)));
            exist = isATradeWithSameTrader(tradeArrayList, trade.partnerId());
        }
        if(!exist){
            repository.save(tradeMapper.tradeToTradeEntity(trade,utils.findUser(id), utils.findUser(trade.partnerId()), id));
        }else{
            throw new RuntimeException("A trade with this trader is already open ");
        }
    }

    @Override
    public TradeList findAllTradesByUserId(Long id){
        List<TradeEntity> tradeList = repository.findByInitiator_IdOrPartner_Id(id, id);
        List<Trade> trades = new ArrayList<>();
        tradeList.forEach(t ->trades.add(tradeMapper.tradeEntityToTrade(t)));
        return new TradeList(trades);
    }

    @Override
    public Trade findOneTradeById(Long tradeId, Long currentId){
        TradeEntity trade = utils.getOneTrade(tradeId);
        if(isAParticipantOfTheTrade(tradeMapper.tradeEntityToTrade(trade), currentId)){
            return tradeMapper.tradeEntityToTrade(trade);
        }else{
            throw new RuntimeException("you can't have access to this resource");
        }
    }


    @Override
    public void updateStatusTrade(TradeUpdate trade, Long id){
        TradeEntity oneTrade = repository.findById(trade.tradeId()).orElseThrow(() -> new IllegalArgumentException("trade not found with id: " + trade.tradeId()));
        Trade tradeComparator = tradeMapper.tradeEntityToTrade(oneTrade);
        if(isInitiatorTrader(id, tradeComparator)){
            oneTrade.setStatus(trade.mapTradeStatus(trade.status().toUpperCase()));
            oneTrade.setClotureDate(LocalDateTime.now());
            repository.save(oneTrade);
        }else{
            throw new RuntimeException("You have no right to update this trade");
        }
    }

}
