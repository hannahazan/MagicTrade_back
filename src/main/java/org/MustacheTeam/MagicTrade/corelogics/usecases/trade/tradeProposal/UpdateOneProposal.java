package org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;

public class UpdateOneProposal {
    private final TradeProposalRepository repository;

    public UpdateOneProposal(TradeProposalRepository tradeProposalRepository){
        this.repository = tradeProposalRepository;
    }

    public void handle(TradeProposal proposal, Long actualProposerId){
        repository.updateTradeProposalStatus(proposal, actualProposerId);
    }

}
