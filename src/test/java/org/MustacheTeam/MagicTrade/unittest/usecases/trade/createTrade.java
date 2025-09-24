package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryTradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.usecases.trade.CreateTrade;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class createTrade {
    private InMemoryTradeRepository repository = new InMemoryTradeRepository();
    private CreateTrade createTrade = new CreateTrade(repository);

    @Test
   void should_create_one_trade(){
        Trade trade = new Trade(
                1L,
               1L,
               2L,
                true,
                true,
                LocalDateTime.of(2025,8,27,11,0,0),
                LocalDateTime.of(2025,8,27,16,0,0),
                true,
                true,
                false

        );
    }
}
