package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.GetOneTradeById;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GetOneTradeByIdTest {


    private final InMemoryTradeRepository repository = new InMemoryTradeRepository();
    private final CreateTrade createTrade = new CreateTrade(repository);
    private final GetOneTradeById getOneTradeById = new GetOneTradeById(repository);


    @Test
    void should_return_the_expected_trade_by_id(){
        // Arrange
        Long initiator = 5L; Long partner = 6L;
        createTrade.handle(new TradeToSave(partner, new TradeProposalToSave(null, "Hello", null)), initiator);
        Trade created = repository.findAllTradesByUserId(initiator).trades().getFirst();

        // Act
        Trade found = getOneTradeById.handle(created.id(), initiator);

        // Assert
        assertThat(found).isNotNull();
        assertThat(found.id()).isEqualTo(created.id());
        assertThat(found.initiatorId()).isEqualTo(initiator);
        assertThat(found.partnerId()).isEqualTo(partner);
    }
}
