package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTradeProposalTest {


    private final InMemoryTradeProposalRepository repository = new InMemoryTradeProposalRepository();
    private final CreateTradeProposal createTradeProposal = new CreateTradeProposal(repository);


    @Test
    void should_create_proposal_with_pending_status(){
        // Arrange
        Long tradeId = 1L; Long proposer = 10L;
        TradeProposalToSave toSave = new TradeProposalToSave(tradeId, "offer", null);

        // Act
        createTradeProposal.handle(toSave, proposer);

        // Assert
        var list = repository.getAllTradeProposalByTradeId(tradeId, proposer).tradeProposals();
        assertThat(list).hasSize(1);
        assertThat(list.getFirst().status()).isEqualTo("PENDING");
        assertThat(list.getFirst().proposerId()).isEqualTo(proposer);
    }
}
