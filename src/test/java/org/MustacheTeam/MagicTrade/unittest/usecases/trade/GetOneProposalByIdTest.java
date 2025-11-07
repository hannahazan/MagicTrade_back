package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.CreateTradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.tradeProposal.GetOneProposalById;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetOneProposalByIdTest {


    private final InMemoryTradeProposalRepository repository = new InMemoryTradeProposalRepository();
    private final CreateTradeProposal createTradeProposal = new CreateTradeProposal(repository);
    private final GetOneProposalById getOne = new GetOneProposalById(repository);

    @Test
    void should_return_expected_proposal_by_id(){
        // Arrange
        Long tradeId = 3L; Long proposer = 77L;
        createTradeProposal.handle(new TradeProposalToSave(tradeId, "first", null), proposer);
        Long id = repository.getAllTradeProposalByTradeId(tradeId, proposer).tradeProposals().get(0).id();

        // Act
        TradeProposal found = getOne.handle(id, proposer);

        // Assert
        assertThat(found).isNotNull();
        assertThat(found.id()).isEqualTo(id);
        assertThat(found.tradeId()).isEqualTo(tradeId);
        assertThat(found.proposerId()).isEqualTo(proposer);
    }
}
