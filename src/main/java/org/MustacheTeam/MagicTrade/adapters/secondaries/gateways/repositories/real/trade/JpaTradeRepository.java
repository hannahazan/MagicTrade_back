package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;

public class JpaTradeRepository implements TradeRepository {

    private final SpringDataTradeRepository repository;

    public JpaTradeRepository(SpringDataTradeRepository repository){
        this.repository = repository;
    }

    public void save(Trade trade, Long id){
        TradeEntity tradeEntity = new TradeEntity(
                id,
                trade.partnerId(),
                trade.validationInitiator(),
                trade.validationPartner(),
                trade.creationDate(),
                trade.clotureDate(),
                trade.clotureInitiator(),
                trade.cloturePartner(),
                trade.warningCloture()
        );
        repository.save(tradeEntity);
    }
}
