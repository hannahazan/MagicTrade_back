package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.GetAllTradesByUserId;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllTradesByUserIdTest {


    private final InMemoryTradeRepository repository = new InMemoryTradeRepository();
    private final CreateTrade createTrade = new CreateTrade(repository);
    private final GetAllTradesByUserId getAllTradesByUserId = new GetAllTradesByUserId(repository);


    @Test
    void should_return_trades_where_user_is_initiator_or_partner(){
        // Arrange
        Long alice = 1L; Long bob = 2L; Long charlie = 3L;
        createTrade.handle(new TradeToSave(bob, new TradeProposalToSave(null, "A->B", null)), alice);
        createTrade.handle(new TradeToSave(alice, new TradeProposalToSave(null, "B->A", null)), bob);
        createTrade.handle(new TradeToSave(bob, new TradeProposalToSave(null, "C->B", null)), charlie);

        // Act
        TradeList forAlice = getAllTradesByUserId.handle(alice);
        TradeList forBob = getAllTradesByUserId.handle(bob);

        // Assert
        assertThat(forAlice.trades()).hasSize(2);
        assertThat(forBob.trades()).hasSize(3);
    }
}
