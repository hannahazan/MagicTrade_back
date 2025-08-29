package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeList;

public interface TradeRepository {
  void save(Trade trade, Long id);
  TradeList findAllTradesByUserId(Long id);
}
