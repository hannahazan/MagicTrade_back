package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.CardEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository {

    void save(List<ScryfallCard> cardToSave);

    CardEntity getCardById(String id);

    List<CardEntity> getAllCards(String name, String setId, List<String> colors, List<Integer> cmc, String text, List<String> toughnesses,
                                 List<String> powers, List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard,
                                 String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String commander, String brawl,
                                 String pauperCommander, String duel, String oldSchool);
}
