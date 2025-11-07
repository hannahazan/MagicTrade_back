package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.GetAllProposalsByOneTrades;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllProposalsByOneTradesTest {


    private final InMemoryTradeProposalRepository repository = new InMemoryTradeProposalRepository();
    private final CreateTradeProposal createTradeProposal = new CreateTradeProposal(repository);
    private GetAllProposalsByOneTrades getAll = new GetAllProposalsByOneTrades(repository);


    @Test
    void should_return_only_proposals_for_given_trade(){
// Arrange
        Long trade1 = 1L; Long trade2 = 2L; Long alice = 10L; Long bob = 11L;
        createTradeProposal.handle(new TradeProposalToSave(trade1, "p1", null), alice);
        createTradeProposal.handle(new TradeProposalToSave(trade1, "p2", null), bob);
        createTradeProposal.handle(new TradeProposalToSave(trade2, "p3", null), alice);


// Act
        TradeProposalList list = getAll.handle(trade1, alice);


// Assert
        assertThat(list.tradeProposals()).hasSize(2);
        assertThat(list.tradeProposals()).allMatch(p -> p.tradeId().equals(trade1));
    }
}
