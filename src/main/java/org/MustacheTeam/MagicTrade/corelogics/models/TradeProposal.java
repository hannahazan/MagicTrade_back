package org.MustacheTeam.MagicTrade.corelogics.models;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;

import java.time.LocalDateTime;
import java.util.List;

public record TradeProposal(
        Long id,
        Long tradeId,
        Long proposerId,
        String status,
        LocalDateTime creationDate,
        List<Long> collectionCards,
        String message
) {
}
