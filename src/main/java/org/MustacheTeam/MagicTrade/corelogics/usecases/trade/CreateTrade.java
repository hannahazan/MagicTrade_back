package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;

public class CreateTrade {
    private final TradeRepository repository;

    public CreateTrade(TradeRepository repository){
        this.repository = repository;
    }

    public void handle(TradeToSave trade, Long id){
        repository.save(trade, id);
    }
}
