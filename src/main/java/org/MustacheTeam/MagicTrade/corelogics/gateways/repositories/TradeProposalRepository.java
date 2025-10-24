package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;

public interface TradeProposalRepository {
    void save(TradeProposalToSave proposal, Long id);
    TradeProposalList getAllTradeProposalByTradeId(Long tradeId, Long currentId);
    TradeProposal getOneProposalById(Long proposalId, Long currentId);
    void  updateTradeProposalStatus(ProposalUpdate proposal, Long actualProposerId);
}
