package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;
import org.MustacheTeam.MagicTrade.corelogics.utils.MapperTradeStatus;

public record TradeUpdate(Long tradeId, String status) {


    public TradeStatus mapTradeStatus(String status){
       return MapperTradeStatus.mapTradeStatus(status);
    }
}
