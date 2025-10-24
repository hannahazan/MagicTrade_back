package org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;

public class UpdateOneProposal {
    private final TradeProposalRepository repository;

    public UpdateOneProposal(TradeProposalRepository tradeProposalRepository){
        this.repository = tradeProposalRepository;
    }

    public void handle(ProposalUpdate proposal, Long actualProposerId){
        repository.updateTradeProposalStatus(proposal, actualProposerId);
    }

}
