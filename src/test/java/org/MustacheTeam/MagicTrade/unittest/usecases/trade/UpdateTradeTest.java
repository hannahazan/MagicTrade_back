package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeUpdate;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.UpdateTrade;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class UpdateTradeTest {

    private final InMemoryTradeRepository repository = new InMemoryTradeRepository();
    private final CreateTrade createTrade = new CreateTrade(repository);
    private final UpdateTrade updateTrade = new UpdateTrade(repository);


    @Test
    void should_update_status_to_closed(){
        // Arrange
        Long initiator = 7L; Long partner = 8L;
        createTrade.handle(new TradeToSave(partner, new TradeProposalToSave(null, "deal", null)), initiator);
        Trade created = repository.findAllTradesByUserId(initiator).trades().getFirst();

        // Act
        updateTrade.handle(new TradeUpdate(created.id(), "CLOSED"), initiator);

        // Assert
        Trade updated = repository.findOneTradeById(created.id(), initiator);
        assertThat(updated.status()).isEqualTo("CLOSED");
        assertThat(updated.clotureDate()).isNotNull();
    }


    @Test
    void should_update_status_to_cancelled(){
        // Arrange
        Long initiator = 9L; Long partner = 10L;
        createTrade.handle(new TradeToSave(partner, new TradeProposalToSave(null, "deal", null)), initiator);
        Trade created = repository.findAllTradesByUserId(initiator).trades().getFirst();

        // Act
        updateTrade.handle(new TradeUpdate(created.id(), "CANCELLED"), initiator);

        // Assert
        Trade updated = repository.findOneTradeById(created.id(), initiator);
        assertThat(updated.status()).isEqualTo("CANCELLED");
        assertThat(updated.clotureDate()).isNotNull();
    }


    @Test
    void should_throw_when_status_is_invalid(){
        // Arrange
        Long initiator = 11L; Long partner = 12L;
        createTrade.handle(new TradeToSave(partner, new TradeProposalToSave(null, "deal", null)), initiator);
        Trade created = repository.findAllTradesByUserId(initiator).trades().getFirst();

        // Act + Assert
        assertThatThrownBy(() -> updateTrade.handle(new TradeUpdate(created.id(), "OPEN"), initiator))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid Status");
    }
}
