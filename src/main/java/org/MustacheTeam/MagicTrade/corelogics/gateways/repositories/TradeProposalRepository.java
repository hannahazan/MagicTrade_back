package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalList;

public interface TradeProposalRepository {
    void save(TradeProposal proposal, Long id);
    TradeProposalList getAllTradeProposalByTradeId(Long tradeId);
    void  updateTradeProposalStatus(ProposalUpdate proposal, Long actualProposerId);
}
