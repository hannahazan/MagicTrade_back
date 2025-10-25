package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import java.util.List;

public record TradeToSave(
        Long partnerId,
        TradeProposalToSave proposal
) {
}
