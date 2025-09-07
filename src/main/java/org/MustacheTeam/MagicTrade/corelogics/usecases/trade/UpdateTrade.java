package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;

public class UpdateTrade {
    private final TradeRepository repository;

    public UpdateTrade(TradeRepository repository){
        this.repository = repository;
    }

    public void handle(Trade trade, Long Userid){
        repository.updateStatusTrade(trade, Userid);
    }
}
