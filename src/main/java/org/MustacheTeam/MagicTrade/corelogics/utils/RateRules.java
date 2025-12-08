package org.MustacheTeam.MagicTrade.corelogics.utils;

import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rated;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RateRules {

    public boolean areAllParticipantsOfTheTrade(Long raterId, Long ratedId, Trade trade){
        AtomicBoolean result = new AtomicBoolean(false);
        if((trade.partnerId().equals(raterId) && trade.initiatorId().equals(ratedId)) || (trade.initiatorId().equals(raterId) && trade.partnerId().equals(ratedId))){
            result.set(true);
        }
        return result.get();
    }

    public boolean isTradeClosed(Trade trade){
        AtomicBoolean result = new AtomicBoolean(false);
        if(trade.status() .equals("CLOSED")){
            result.set(true);
        }
        return result.get();
    }
}
