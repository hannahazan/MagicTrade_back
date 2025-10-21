package org.MustacheTeam.MagicTrade.corelogics.utils.trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TradeRules {

    public boolean isATradeWithSameTrader(List<Trade> trades,Long idPartner){
        AtomicBoolean exist = new AtomicBoolean(false);
        if(!trades.isEmpty()){
            trades.forEach( t -> {
                if((t.partnerId().equals(idPartner) || t.initiatorId().equals(idPartner)) && t.status().equals("OPEN")){
                    exist.set(true);
                }
            });
        }
        return exist.get();
    }

    public boolean isInitiatorTrader(Long id, Trade trade){
        AtomicBoolean right = new AtomicBoolean(false);
        if(trade.initiatorId().equals(id)){
            right.set(true);
        }
        return right.get();
    }

}
