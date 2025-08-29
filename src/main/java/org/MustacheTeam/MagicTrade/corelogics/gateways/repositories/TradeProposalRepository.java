package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.*;

import java.util.List;

public interface TradeProposalRepository {
    void save(TradeProposal proposal, Long id);
    TradeProposalList getAllTradeProposalByTradeId(Long tradeId);
}
