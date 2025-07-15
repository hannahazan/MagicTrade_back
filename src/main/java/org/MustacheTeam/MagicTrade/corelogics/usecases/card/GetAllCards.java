package org.MustacheTeam.MagicTrade.corelogics.usecases.card;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.CardEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllCards {

    private final CardRepository cardRepository;

    public GetAllCards(CardRepository cardRepository){
       this.cardRepository = cardRepository;
    }

    public CardList handle(String id,String name, String setId, List<String> colors, List<Integer> cmc, String text, List<String> toughnesses, List<String> powers,
                           List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard, String pioneer, String explorer, String modern,
                           String legacy, String pauper, String vintage, String commander, String brawl, String pauperCommander, String duel, String oldSchool) {
        List<Card> cards = new ArrayList<>();
        cardRepository.getAllCards(id,name, setId, colors, cmc, text, toughnesses, powers, rarities, types, foil,
                fullArt, textLess, standard, pioneer, explorer, modern, legacy, pauper, vintage, commander, brawl, pauperCommander, duel, oldSchool).forEach(c->cards.add(new Card(c.getId(),c.getSetId(),
                c.getName(),c.getManaCost(),c.getCmc(),c.getTypes(),c.getText(),c.getToughness(),c.getPower(),c.getRarity(),c.getFoil(),c.getFullArt(),c.getTextLess(),
                c.getCardMarketPrice(),c.getStandard(),c.getPioneer(),c.getExplorer(),c.getModern(),c.getLegacy(),c.getPauper(),c.getVintage(),c.getCommander(),c.getBrawl(),c.getPauperCommander(),
                c.getDuel(),c.getOldSchool(),c.getImageSizeNormal(),c.getImageSizeArtCrop())));

        return new CardList(cards);
    }
}
