package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;

public class GetOneTradeById {
    private final TradeRepository tradeRepository;

    public GetOneTradeById(TradeRepository tradeRepository){
        this.tradeRepository = tradeRepository;
    }

    public Trade handle(Long tradeId, Long currentId){
        return tradeRepository.findOneTradeById(tradeId, currentId);
    }
}
