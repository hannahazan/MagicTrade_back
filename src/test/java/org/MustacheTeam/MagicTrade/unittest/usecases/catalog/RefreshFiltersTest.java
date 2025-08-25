package org.MustacheTeam.MagicTrade.unittest.usecases.catalog;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.FakeScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryCatalogRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability.RefreshAbilities;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RefreshFiltersTest {
    private final InMemoryCatalogRepository repository = new InMemoryCatalogRepository();
    private final FakeScryfallGateway scryfallGateway = new FakeScryfallGateway();
    private final RefreshAbilities refreshAbilities = new RefreshAbilities(scryfallGateway, repository);

    @Test
    void should_save_List_of_String(){
        //Arrange
        List<String> catalog = List.of("a", "b");
        scryfallGateway.feedFilters(catalog);
        refreshAbilities.handle("catalogElementName");

        Filters expected = new Filters(List.of("a","b"));

        //Act
        Filters actual = repository.getAllAbilities();

        //Assert
        assertThat(expected).isEqualTo(actual);

    }
}
