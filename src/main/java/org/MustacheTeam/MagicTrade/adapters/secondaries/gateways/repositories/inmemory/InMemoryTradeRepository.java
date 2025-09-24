package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTradeRepository implements TradeRepository {
     List<Trade> tradeList = new ArrayList<>();

     public void save(Trade trade, Long id){
            tradeList.add(trade);
    }

    public TradeList findAllTradesByUserId(Long id){
         List<Trade> trades = new ArrayList<>();
         return new TradeList(trades);
     }

     public void updateStatusTrade(TradeUpdate trade, Long id){

     }
}
