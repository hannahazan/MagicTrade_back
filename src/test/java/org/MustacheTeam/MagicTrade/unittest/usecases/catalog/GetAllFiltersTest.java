package org.MustacheTeam.MagicTrade.unittest.usecases.catalog;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryCatalogRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability.GetAllAbilities;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.artifacttype.GetAllArtifactType;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardname.GetAllCardNames;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.creaturetype.GetAllCreatureTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.enchantmentType.GetAllEnchantmentTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.landtype.GetAllLandTypes;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.power.GetAllPowers;
import org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.toughness.GetAllToughnesses;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllFiltersTest {

    private final InMemoryCatalogRepository repository = new InMemoryCatalogRepository();
    private final GetAllAbilities getAllAbilities = new GetAllAbilities(repository);
    private final GetAllCreatureTypes getAllCreatureTypes = new GetAllCreatureTypes(repository);
    private final GetAllPowers getAllPowers = new GetAllPowers(repository);
    private final GetAllToughnesses getAllToughnesses = new GetAllToughnesses(repository);
    private final GetAllLandTypes getAllLandTypes = new GetAllLandTypes(repository);
    private final GetAllEnchantmentTypes getAllEnchantmentTypes = new GetAllEnchantmentTypes(repository);
    private final GetAllArtifactType getAllArtifactType = new GetAllArtifactType(repository);
    private final GetAllCardNames getAllCardNames = new GetAllCardNames(repository);
    private final GetAllCardTypes getAllCardTypes = new GetAllCardTypes(repository);

    @Test
    void should_return_Filter_object_when_get_abilities(){
        //Arrange
        List<String> abilities = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(abilities);
        repository.feedFilters(abilities);

        //Actual
        Filters actual = getAllAbilities.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_getAllCreatureTypes(){
        //Arrange
        List<String> abilities = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(abilities);
        repository.feedFilters(abilities);

        //Actual
        Filters actual = getAllCreatureTypes.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllPowers(){
        //Arrange
        List<String> powers = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(powers);
        repository.feedFilters(powers);

        //Actual
        Filters actual = getAllPowers.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllToughnesses(){
        //Arrange
        List<String> toughnesses = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(toughnesses);
        repository.feedFilters(toughnesses);

        //Actual
        Filters actual = getAllToughnesses.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllLandTypes(){
        //Arrange
        List<String> landTypes = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(landTypes);
        repository.feedFilters(landTypes);

        //Actual
        Filters actual = getAllLandTypes.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllEnchantmentTypes(){
        //Arrange
        List<String> enchantmentTypes = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(enchantmentTypes);
        repository.feedFilters(enchantmentTypes);

        //Actual
        Filters actual = getAllEnchantmentTypes.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllArtifactType(){
        //Arrange
        List<String> artifactTypes = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(artifactTypes);
        repository.feedFilters(artifactTypes);

        //Actual
        Filters actual = getAllArtifactType.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllCardNames(){
        //Arrange
        List<String> cardNames = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(cardNames);
        repository.feedFilters(cardNames);

        //Actual
        Filters actual = getAllCardNames.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void should_return_Filter_object_when_get_getAllCardTypes(){
        //Arrange
        List<String> cardTypes = List.of(
                "Eerie",
                "Battalion",
                "Bloodrush",
                "Channel",
                "Chroma",
                "Cohort",
                "Constellation",
                "Converge",
                "Delirium"
        );
        Filters expected = new Filters(cardTypes);
        repository.feedFilters(cardTypes);

        //Actual
        Filters actual = getAllCardTypes.handle();

        //Assert
        assertThat(expected).isEqualTo(actual);
    }
}
