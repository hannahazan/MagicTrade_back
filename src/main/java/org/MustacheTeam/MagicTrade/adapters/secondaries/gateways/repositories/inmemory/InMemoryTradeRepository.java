package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTradeRepository implements TradeRepository {
     List<Trade> tradeList = new ArrayList<>();

     public void save(Trade trade, Long id){
            tradeList.add(trade);
    }
}
