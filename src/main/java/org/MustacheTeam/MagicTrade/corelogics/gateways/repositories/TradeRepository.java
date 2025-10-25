package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;

public interface TradeRepository {
  void save(TradeToSave trade, Long id);
  TradeList findAllTradesByUserId(Long id);
  Trade findOneTradeById(Long id, Long currentId);
  void updateStatusTrade(TradeUpdate trade, Long id);
}
