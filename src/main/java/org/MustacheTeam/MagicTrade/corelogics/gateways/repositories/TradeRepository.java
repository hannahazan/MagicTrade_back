package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;

public interface TradeRepository {
  void save(Trade trade, Long id);
  TradeList findAllTradesByUserId(Long id);
  void updateStatusTrade(TradeUpdate trade, Long id);
}
