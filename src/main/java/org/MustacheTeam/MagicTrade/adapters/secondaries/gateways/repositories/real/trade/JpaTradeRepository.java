package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.*;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class JpaTradeRepository implements TradeRepository {

    private final SpringDataTradeRepository repository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCollectionRepository collectionRepository;

    public JpaTradeRepository(SpringDataTradeRepository repository, SpringDataUserRepository springDataUserRepository,SpringDataCollectionRepository collectionRepository){
        this.repository = repository;
        this.userRepository = springDataUserRepository;
        this.collectionRepository = collectionRepository;
    }

    public void save(Trade trade, Long id){
        List<TradeEntity> trades = repository.findByInitiator_IdOrPartner_Id(id, id);
        boolean exist = isATradeWithSameTrader(trades, trade.partnerId(), id);
        if(!exist){
            List<TradeProposalEntity> proposalEntityList = new ArrayList<>();
            TradeEntity tradeEntity = new TradeEntity(
                    findUser(id),
                    findUser(trade.partnerId()),
                    LocalDateTime.now(),
                    trade.clotureDate(),
                    TradeStatus.OPEN
            );
            trade.proposals().forEach( p ->{
                List<TradeProposalItemEntity> items = new ArrayList<>();
                TradeProposalEntity proposal;
                UserEntity proposer = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id:"));
                proposalEntityList.add(
                        proposal =  new TradeProposalEntity(
                                tradeEntity,
                                proposer,
                                p.mapProposalStatus(p.status()),
                                LocalDateTime.now(),
                                p.message()
                        )
                );
                p.tradeItemProposals().forEach( i->{
                    CollectionEntity collection = collectionRepository.findById(i.userCard().id()).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: "));
                    items.add(
                            new TradeProposalItemEntity(
                                    proposal,
                                    collection,
                                    i.getSide(collection.getUserId().getId(),id)
                            )
                    );
                });
                proposal.setTradeItemProposalList(items);
            });
            tradeEntity.setTradeProposalList(proposalEntityList);
            repository.save(tradeEntity);

        }else{
            throw new RuntimeException("A trade with this trader is already open ");
        }
    }

    public boolean isATradeWithSameTrader(List<TradeEntity> trades,Long idPartner, Long id){
        AtomicBoolean exist = new AtomicBoolean(false);
        trades.forEach( t -> {
            if(((t.getPartner().getId().equals(id) && t.getInitiator().getId().equals(idPartner) )|| (t.getPartner().getId().equals(idPartner)))&& t.getStatus().name().equals("OPEN")){
                exist.set(true);
            }
        });
        return exist.get();
    }

    public TradeList findAllTradesByUserId(Long id){
        List<TradeEntity> tradeList = repository.findByInitiator_IdOrPartner_Id(id, id);
        List<Trade> trades = new ArrayList<>();
        tradeList.forEach( t ->{
            List<TradeProposal> proposalList = new ArrayList<>();
            t.getTradeProposalList().forEach(p ->{
                List<TradeItemProposal> items = new ArrayList<>();
                p.getTradeItemProposalList().forEach( i ->{
                            items.add(new TradeItemProposal(
                                    i.getId(),
                                    i.getProposal().getId(),
                                    new Collection(
                                            i.getCollectionCard().getId(),
                                            i.getCollectionCard().getUserId().getId(),
                                            i.getCollectionCard().getCardId().getId(),
                                            i.getCollectionCard().getLang(),
                                            i.getCollectionCard().getState()
                                    ),
                                    i.getCollectionCard().getCardId().getImageSizeNormal(),
                                    i.getSide().name()
                            ));
                        }
                        );
                    proposalList.add(new TradeProposal(
                            p.getId(),
                            p.getTrade().getId(),
                            p.getProposer().getId(),
                            p.getStatus().name(),
                            p.getCreatedAt(),
                            p.getMessage(),
                            items
                    ));
                }
            );
            trades.add(
                    new Trade(
                            t.getId(),
                            t.getInitiator().getId(),
                            t.getPartner().getId(),
                            proposalList,
                            t.getCreationDate(),
                            t.getClotureDate(),
                            t.getStatus().toString()
                    )
            );
        } );
        return new TradeList(trades);
    }

    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public void updateStatusTrade(Trade trade, Long id){
        TradeEntity oneTrade = repository.findById(trade.id()).orElseThrow(() -> new IllegalArgumentException("trade not found with id: " + trade.id()));
        if(isInitiatorTrader(id, oneTrade)){
            oneTrade.setStatus(trade.mapTradeStatus(trade.status()));
            oneTrade.setClotureDate(LocalDateTime.now());
            repository.save(oneTrade);
        }else{
            throw new RuntimeException("You have no right to update this trade");
        }
    }

    public boolean isInitiatorTrader(Long id, TradeEntity trade){
        AtomicBoolean right = new AtomicBoolean(false);
        if(trade.getInitiator().getId().equals(id)){
            right.set(true);
        }
        return right.get();
    }

}
