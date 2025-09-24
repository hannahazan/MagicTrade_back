package org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;

public class CreateTradeProposal {
    private final TradeProposalRepository repository;

    public CreateTradeProposal(TradeProposalRepository repository){
        this.repository = repository;
    }

    public void handle(TradeProposal proposal, Long id){
        repository.save(proposal, id);
    }
}
