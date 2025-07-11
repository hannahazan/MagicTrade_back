package org.MustacheTeam.MagicTrade.repository.card;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository {

    void save(List<ScryfallCard> cardToSave);

    Card getCardById(String id);

    List<Card> getAllCards(String name, String setId, List<String> colors, List<Integer> cmc, String text, List<String> toughnesses,
                           List<String> powers, List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard,
                           String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String commander, String brawl,
                           String pauperCommander, String duel, String oldSchool);
}
