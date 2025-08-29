package org.MustacheTeam.MagicTrade.corelogics.models;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

import java.time.LocalDateTime;

public record Trade(
        Long id,
        Long initiatorId,
        Long partnerId,
        LocalDateTime creationDate,
        LocalDateTime clotureDate,
        String status
) {
}
