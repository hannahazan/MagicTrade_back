package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTradeRepository implements TradeRepository {

    private final SpringDataTradeRepository repository;
    private final SpringDataUserRepository userRepository;

    public JpaTradeRepository(SpringDataTradeRepository repository, SpringDataUserRepository springDataUserRepository){
        this.repository = repository;
        this.userRepository = springDataUserRepository;
    }

    public void save(Trade trade, Long id){
        TradeEntity tradeEntity = new TradeEntity(
                findUser(id),
                findUser(trade.partnerId()),
                LocalDateTime.now(),
                trade.clotureDate(),
                TradeStatus.OPEN
        );
        repository.save(tradeEntity);
    }

    public TradeList findAllTradesByUserId(Long id){
        List<TradeEntity> tradeEntities = repository.findAllByInitiator_Id(id);
        List<Trade> trades = new ArrayList<>();
        tradeEntities.forEach( t -> trades.add(
                new Trade(
                        t.getId(),
                        t.getInitiator().getId(),
                        t.getPartner().getId(),
                        t.getCreationDate(),
                        t.getClotureDate(),
                        t.getStatus().toString()
                )
        ));
        return new TradeList(trades);
    }

    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

}
