package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import java.util.List;

public record TradeProposalToSave(
        Long tradeId,
        String message,
        List<TradeItemToSave> items
) {
}
