package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.GetAllProposalsByOneTrades;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.GetOneProposalById;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.UpdateOneProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/trade_proposal")
public class TradeProposalController {
    @Autowired
    CreateTradeProposal createTradeProposal;

    @Autowired
    GetAllProposalsByOneTrades getAllProposalsByOneTrades;

    @Autowired
    UpdateOneProposal updateOneProposal;

    @Autowired
    GetOneProposalById getOneProposalById;

    @PostMapping
    public void create(@RequestBody TradeProposalToSave proposal, @AuthenticationPrincipal CurrentTrader currentTraderId){
        createTradeProposal.handle(proposal, currentTraderId.getId());
    }

    @GetMapping(value = "/{tradeId}")
    public TradeProposalList getProposalsForTrade(@PathVariable Long tradeId, @AuthenticationPrincipal CurrentTrader currentTraderId){
        return getAllProposalsByOneTrades.handle(tradeId, currentTraderId.getId());
    }

    @GetMapping(value = "/proposal/{tradeProposalId}")
    public TradeProposal getOneProposal(@PathVariable Long tradeProposalId, @AuthenticationPrincipal CurrentTrader currentTraderId){
        return getOneProposalById.handle(tradeProposalId, currentTraderId.getId());
    }

    @PutMapping(value = "/update")
    public void update(@RequestBody ProposalUpdate proposal, @AuthenticationPrincipal CurrentTrader currentTraderId){
        updateOneProposal.handle(proposal, currentTraderId.getId());
    }
}
