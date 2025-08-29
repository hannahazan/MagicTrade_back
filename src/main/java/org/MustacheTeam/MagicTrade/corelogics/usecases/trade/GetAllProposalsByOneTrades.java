package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposalList;

public class GetAllProposalsByOneTrades {
    private final TradeProposalRepository repository;

    public GetAllProposalsByOneTrades(TradeProposalRepository repository){
        this.repository = repository;
    }

    public TradeProposalList handle(Long tradeId){
        return repository.getAllTradeProposalByTradeId( tradeId);
    }
}
