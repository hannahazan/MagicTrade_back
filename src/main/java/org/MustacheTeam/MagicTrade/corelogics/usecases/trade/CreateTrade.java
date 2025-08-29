package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;

public class CreateTrade {
    private final TradeRepository repository;

    public CreateTrade(TradeRepository repository){
        this.repository = repository;
    }

    public void handle(Trade trade, Long id){
        repository.save(trade, id);
    }
}
