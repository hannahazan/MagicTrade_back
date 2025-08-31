package org.MustacheTeam.MagicTrade.corelogics.models;

import java.time.LocalDateTime;
import java.util.List;

public record Trade(
        Long id,
        Long initiatorId,
        Long partnerId,
        List<TradeProposal> proposals,
        LocalDateTime creationDate,
        LocalDateTime clotureDate,
        String status
) {
}
