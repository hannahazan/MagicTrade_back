package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTradeTest {


    private  final InMemoryTradeRepository repository = new InMemoryTradeRepository();
    private final CreateTrade createTrade = new CreateTrade(repository);


    @Test
    void should_save_trade_with_status_open_and_proposal_pending(){
        // Arrange
        Long initiatorId = 10L;
        Long partnerId = 20L;
        TradeToSave toSave = new TradeToSave(partnerId, new TradeProposalToSave(null, "First offer", null));

        // Act
        createTrade.handle(toSave, initiatorId);

        // Assert
        Trade stored = repository.findAllTradesByUserId(initiatorId).trades().get(0);
        assertThat(stored.initiatorId()).isEqualTo(initiatorId);
        assertThat(stored.partnerId()).isEqualTo(partnerId);
        assertThat(stored.status()).isEqualTo("OPEN");
        assertThat(stored.proposals()).hasSize(1);
        assertThat(stored.proposals().get(0).status()).isEqualTo("PENDING");
        assertThat(stored.proposals().get(0).message()).isEqualTo("First offer");
    }
}
