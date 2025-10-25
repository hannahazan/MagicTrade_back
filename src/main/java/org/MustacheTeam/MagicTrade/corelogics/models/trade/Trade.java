package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.MapperTradeStatus;

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
      return MapperTradeStatus.mapTradeStatus(status);
    }
}
