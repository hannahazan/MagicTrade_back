package org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;

public class GetOneProposalById {
    private final TradeProposalRepository repository;

    public GetOneProposalById(TradeProposalRepository repository){
        this.repository = repository;
    }

    public TradeProposal handle(Long tradeProposalId, Long currentId){
        return repository.getOneProposalById(tradeProposalId, currentId);
    }
}
