package org.MustacheTeam.MagicTrade.corelogics.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposalList;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreateTrade {
    private final TradeRepository repository;

    public CreateTrade(TradeRepository repository){
        this.repository = repository;
    }

    public void handle(Trade trade, Long id){
        repository.save(trade, id);
    }
}
