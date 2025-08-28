package org.MustacheTeam.MagicTrade.corelogics.models;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;

public record TradeItemProposal(
        Long id,
        Long tradeProposalId,
        Long cardId,
        String side
) {
}
