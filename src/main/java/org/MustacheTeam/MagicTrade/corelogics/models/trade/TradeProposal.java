package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.MapperPorposalStatus;

import java.time.LocalDateTime;
import java.util.List;

public record TradeProposal(
        Long id,
        Long tradeId,
        Long proposerId,
        String status,
        LocalDateTime creationDate,
        String message,
        List<TradeItemProposal> tradeItemProposals
) {
    public ProposalStatus mapProposalStatus(String status){
        return MapperPorposalStatus.mapProposalStatus(status);
    }
}
