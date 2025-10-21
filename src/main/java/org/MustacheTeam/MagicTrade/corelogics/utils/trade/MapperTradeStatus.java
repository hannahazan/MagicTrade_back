package org.MustacheTeam.MagicTrade.corelogics.utils.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

public final class MapperTradeStatus {

    public static TradeStatus mapTradeStatus( final String status){
        if(status.equalsIgnoreCase("OPEN")){
            return TradeStatus.OPEN;
        }
        else if(status.equalsIgnoreCase("ACCEPTED")){
            return TradeStatus.ACCEPTED;
        }
        else if(status.equalsIgnoreCase("REJECTED")){
            return TradeStatus.REJECTED;
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
