package org.MustacheTeam.MagicTrade.unittest.usecases.card;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.FakeScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.Illustrations;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.Legalities;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.Prices;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.RefreshCards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefreshCardsTest {

    private final InMemoryCardRepository repository = new InMemoryCardRepository();
    private final FakeScryfallGateway gateway = new FakeScryfallGateway();
    private final RefreshCards refreshCards = new RefreshCards(gateway,repository);

    @Test
    void should_refresh_only_game_cards(){
        //Arrange
        ArrayList<String> games = new ArrayList<>();
        games.add("arena");
        games.add("paper");

        ArrayList<String> gameList = new ArrayList<>();
        gameList.add("arena");
        gameList.add("mtgo");

        ScryfallCard card1 = new ScryfallCard(
                "1",
                "2",
                "Avacyn",
                "{3}{B}{W}",
                5,
                "Creatures",
                "When Avacyn enters the battlefields",
                "5",
                "5",
                "rare",
                true,
                true,
                true,
                new Prices(
                        null,
                        "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                        null
                ),
                new Legalities(
                        "not_legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "not_legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "not_legal"
                ),
                gameList,
                new Illustrations(
                        "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                        "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654"
                ),
                null
        );

        ScryfallCard card2 = new ScryfallCard(
                "2",
                "2",
                "Avacyn",
                "{3}{B}{W}",
                5,
                "Creatures",
                "When Avacyn enters the battlefields",
                "5",
                "5",
                "rare",
                true,
                true,
                true,
                new Prices(
                        null,
                        "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                        null
                ),
                new Legalities(
                        "not_legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "not_legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "legal",
                        "not_legal"
                ),
                games,
                new Illustrations(
                        "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                        "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654"
                ),
                null
        );

        Card exampleCard = new Card(
                "2",
                "2",
                "Avacyn",
                "{3}{B}{W}",
                5,
                "Creatures",
                "When Avacyn enters the battlefields",
                "5",
                "5",
                "rare",
                true,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654");

        gateway.feedScryfallCards(List.of(card1,card2));
        CardList expected = new CardList(List.of(exampleCard));
        refreshCards.handle();

        //Act
        CardList actual = repository.getAllCards("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(expected).isEqualTo(actual);

    }

}
