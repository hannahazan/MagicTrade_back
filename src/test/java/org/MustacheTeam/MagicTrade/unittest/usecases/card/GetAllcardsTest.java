package org.MustacheTeam.MagicTrade.unittest.usecases.card;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory.InMemoryCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.GetAllCards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GetAllcardsTest {

    private final InMemoryCardRepository repository = new InMemoryCardRepository();
    private final GetAllCards getAllCards = new GetAllCards(repository);

    @Test
    void contextLoads() {
    }

    @Test
    void should_return_all_cards_when_all_filters_are_empties(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);


        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card, card2));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_id(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                 "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                 "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                 "3",
                 "3",
                 "mythic",
                 false,
                 false,
                 false,
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
                 "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(Arrays.asList(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("1","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
        ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_colors(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null
        );

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card2));

        //Act
        CardList actual = getAllCards.handle("","","",List.of("W"),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_setId(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","67e47ba2-b019-4181-9005-fe9fc021de44",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_cmc(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                3,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                2,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),List.of("4"),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_text(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more  this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"Pirates",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_toughnesses(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "2",
                "1",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "1",
                "2",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",List.of("3"),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_powers(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "2",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "1",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),List.of("3")
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_rarities(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "rare",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "uncommon",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,List.of("mythic"),new ArrayList<>(),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_types(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "2",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature ",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card3 = new Card(
                "3",
                "1",
                "Admiral Beckett Brass",
                "{1}{W}{B}{R}",
                4,
                "Legendary Creature ",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2, card3));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),List.of("Pirate"),"","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_return_cards_filtered_by_foil(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                true,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"false","","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_fullArt(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","true","","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_textLess(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","true","","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_standard(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","legal","","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_pioneer(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","legal","","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_explorer(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","legal","","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_modern(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","legal","","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_legacy(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
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
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","legal","","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_pauper(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","legal","","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_vintage(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","legal","","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_commander(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","legal","",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_brawl(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","legal",
                "","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_pauperCommander(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "not_legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "legal","","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_duel(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "not_legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","legal","");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void should_return_cards_filtered_by_oldSchool(){
        //Arrange
        Card card = new Card(
                "1",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                true,
                true,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        Card card2 = new Card(
                "2",
                "67e47ba2-b019-4181-9005-fe9fc021de44",
                "Admiral Beckett Brass",
                "{1}{U}{B}{R}",
                4,
                "Legendary Creature — Human Pirate",
                "Other Pirates you control get +1/+1.\nAt the beginning of your end step, gain control of target nonland permanent controlled by a player who was dealt combat damage by three or more Pirates this turn.",
                "3",
                "3",
                "mythic",
                false,
                false,
                false,
                "https://www.cardmarket.com/en/Magic/Products/Singles/The-List/Admiral-Beckett-Brass?referrer=scryfall&utm_campaign=card_prices&utm_medium=text&utm_source=scryfall",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "not_legal",
                "legal",
                "legal",
                "legal",
                "not_legal",
                "https://cards.scryfall.io/normal/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                "https://cards.scryfall.io/art_crop/front/0/0/0004311b-646a-4df8-a4b4-9171642e9ef4.jpg?1651796654",
                false,
                null);

        repository.feedCardsWith(List.of(card, card2));
        CardList expected = new CardList(List.of(card));

        //Act
        CardList actual = getAllCards.handle("","","",new ArrayList<>(),new ArrayList<>(),"",new ArrayList<>(),new ArrayList<>()
                ,new ArrayList<>(),new ArrayList<>(),"","","","","","","","","","","","",
                "","","legal");

        //Assert
        assertThat(actual).isEqualTo(expected);

    }

}
