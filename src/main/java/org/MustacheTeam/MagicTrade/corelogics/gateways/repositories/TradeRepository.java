package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Trade;

public interface TradeRepository {
  void save(Trade trade, Long id);
}
