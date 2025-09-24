package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.GetAllTradesByUserId;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.UpdateTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/trade")
public class TradeController {

    @Autowired
    CreateTrade createTrade;

    @Autowired
    GetAllTradesByUserId getAllTradesByUserId;

    @Autowired
    UpdateTrade updateTrade;

    @PostMapping
    public void create(@RequestBody Trade trade, @AuthenticationPrincipal CurrentTrader currentTraderId){
        createTrade.handle(trade, currentTraderId.getId());
    }

    @GetMapping(value = "/{id}")
    public TradeList getAllTradesByUser(@PathVariable Long id){
        return getAllTradesByUserId.handle(id);
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, @RequestBody TradeUpdate trade, @AuthenticationPrincipal CurrentTrader currentTraderId){
        updateTrade.handle(trade, currentTraderId.getId());
    }

}
