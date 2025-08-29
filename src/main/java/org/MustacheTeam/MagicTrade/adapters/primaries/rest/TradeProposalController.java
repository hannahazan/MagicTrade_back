package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.GetAllProposalsByOneTrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("magicTrade-api/trade_proposal")
public class TradeProposalController {
   @Autowired
   CreateTradeProposal createTradeProposal;

   @Autowired
    GetAllProposalsByOneTrades getAllProposalsByOneTrades;

    @PostMapping
    public void create(@RequestBody TradeProposal proposal, @AuthenticationPrincipal CurrentTrader currentTraderId){
        createTradeProposal.handle(proposal, currentTraderId.getId());
    }

    @GetMapping(value = "/{tradeId}")
    public TradeProposalList getProposalsForTrade(@PathVariable Long tradeId){
        return getAllProposalsByOneTrades.handle(tradeId);
    }
}
