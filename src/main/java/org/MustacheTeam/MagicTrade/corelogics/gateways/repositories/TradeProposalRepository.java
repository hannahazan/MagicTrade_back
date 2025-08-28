package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;

import java.util.List;

public interface TradeProposalRepository {
    void save(TradeProposal proposal, Long id);
}
