package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;

public class UpdateTrade {
    private final TradeRepository repository;

    public UpdateTrade(TradeRepository repository){
        this.repository = repository;
    }

    public void handle(TradeUpdate trade, Long Userid){
        if(trade.status().equalsIgnoreCase("CLOSED") || trade.status().equalsIgnoreCase("CANCELLED")){
            repository.updateStatusTrade(trade, Userid);
        }
        else throw new RuntimeException("Invalid Status");
    }
}
