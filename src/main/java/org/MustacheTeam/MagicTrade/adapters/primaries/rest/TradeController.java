package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magicTrade-api/trade")
public class TradeController {

    @Autowired
    CreateTrade createTrade;

    @PostMapping
    public void create(@RequestBody Trade trade, @AuthenticationPrincipal CurrentTrader currentTraderId){
        createTrade.handle(trade, currentTraderId.getId());
    }
}
