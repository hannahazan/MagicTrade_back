package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;

public class GetAllTradesByUserId {
    private final TradeRepository repository;

    public GetAllTradesByUserId(TradeRepository repository){
        this.repository = repository;
    }

    public TradeList handle(Long id){
        return repository.findAllTradesByUserId(id);
    }
}
