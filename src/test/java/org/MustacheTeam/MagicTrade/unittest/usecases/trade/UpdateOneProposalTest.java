package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.UpdateOneProposal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateOneProposalTest {


    private final InMemoryTradeProposalRepository repository = new InMemoryTradeProposalRepository();
    private final CreateTradeProposal createTradeProposal = new CreateTradeProposal(repository);
    private final UpdateOneProposal updateOneProposal = new UpdateOneProposal(repository);

    @Test
    void should_update_proposal_status_to_accepted(){
        // Arrange
        Long tradeId = 5L; Long alice = 100L;
        createTradeProposal.handle(new TradeProposalToSave(tradeId, "message", null), alice);
        Long proposalId = repository.getAllTradeProposalByTradeId(tradeId, alice).tradeProposals().getFirst().id();

        // Act
        updateOneProposal.handle(new ProposalUpdate(proposalId, "ACCEPTED", null), alice);

        // Assert
        TradeProposal updated = repository.getOneProposalById(proposalId, alice);
        assertThat(updated.status()).isEqualTo("ACCEPTED");
    }
}
