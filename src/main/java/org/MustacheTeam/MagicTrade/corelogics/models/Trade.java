package org.MustacheTeam.MagicTrade.corelogics.models;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

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
    public TradeStatus mapTradeStatus(String status){
        if(status.equalsIgnoreCase("OPEN")){
            return TradeStatus.OPEN;
        }
        else if(status.equalsIgnoreCase("ACCEPTED")){
            return TradeStatus.ACCEPTED;
        }
        else if(status.equalsIgnoreCase("CANCELLED")){
            return TradeStatus.CANCELLED;
        }
        else if(status.equalsIgnoreCase("CLOSED")){
            return TradeStatus.CLOSED;
        }
        return null;
    }
}
