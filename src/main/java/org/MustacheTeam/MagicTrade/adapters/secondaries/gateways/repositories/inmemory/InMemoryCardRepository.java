package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class InMemoryCardRepository implements CardRepository {

    private  List<Card> cards = new ArrayList<>();

    @Override
    public CardList getAllCards(String id, String name, String setId, List<String> colors, List<String> cmc, String text, List<String> toughnesses,
                                  List<String> powers, List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard,
                                  String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String commander, String brawl,
                                  String pauperCommander, String duel, String oldSchool){

           cards =  cards.stream().filter(card -> !id.isEmpty() == id.equals(card.id()) && !setId.isEmpty() == setId.equals(card.setId()) && (colors.isEmpty() || isContaining(colors, card.manaCost()))
                   && (cmc.isEmpty() || isContaining(cmc,String.format("%d",card.cmc()))) && (text.isEmpty() || card.text().contains(text)) && (toughnesses.isEmpty() || isContaining(toughnesses,card.toughness()))
                   && (powers.isEmpty() || isContaining(powers,card.power())) && (rarities.isEmpty() || isContaining(rarities,card.rarity())) && (types.isEmpty() || isContaining(types, card.types()))
                   && !foil.isEmpty() == foil.equals(String.format("%b",card.foil())) && !fullArt.isEmpty() == fullArt.equals(String.format("%b",card.fullArt()))
                   && !textLess.isEmpty() == textLess.equals(String.format("%b",card.textLess())) && !standard.isEmpty() == standard.equals(card.standard())
                   && !pioneer.isEmpty() == pioneer.equals(card.pioneer()) && !explorer.isEmpty() == explorer.equals(card.explorer()) && !modern.isEmpty() == modern.equals(card.modern())
                   && !legacy.isEmpty() == legacy.equals(card.legacy()) && !pauper.isEmpty() == pauper.equals(card.pauper()) && !vintage.isEmpty() == vintage.equals(card.vintage())
                   && !commander.isEmpty() == commander.equals(card.commander()) && !brawl.isEmpty() == brawl.equals(card.brawl()) && !pauperCommander.isEmpty() == pauperCommander.equals(card.standard())
                   && !duel.isEmpty() == duel.equals(card.duel()) && !oldSchool.isEmpty() == oldSchool.equals(card.oldSchool())
           ).toList();

            return new CardList(cards);
    }

    @Override
    public void save(List<ScryfallCard> cardToSave){
        cardToSave.forEach(card->{
            boolean isPaper = false;
            for(int i=0;i<card.games().size();i++){
                if (card.games().get(i).equals("paper")) {
                    isPaper = true;
                    break;
                }
            }
            final Card entityCard = new Card(card.id(), card.setId(), card.name(), card.manaCost(), card.cmc(), card.types(), card.text(), card.toughness(), card.power(), card.rarity(),
                    card.foil(), card.fullArt(), card.textLess(), card.purchase_uris() != null?card.purchase_uris().cardmarket():null, card.legalities().standard(), card.legalities().pioneer(), card.legalities().explorer()
                    , card.legalities().modern(), card.legalities().legacy(), card.legalities().pauper(), card.legalities().vintage(), card.legalities().commander(), card.legalities().brawl()
                    , card.legalities().commander(), card.legalities().duel(), card.legalities().oldschool(), card.image_uris() != null ? card.image_uris().normal() : null, card.image_uris() != null ? card.image_uris().art_crop() : null
            );
            if(isPaper){
                cards.add(entityCard);
            }
        });
    }

    public void feedCardsWith(List<Card> cards){
        this.cards.addAll(cards);
    }

    public boolean isContaining(List<String> listTest, String compare){
        AtomicBoolean isContained = new AtomicBoolean(false);
        listTest.forEach(l->{
            if (compare.contains(l)) {
                isContained.set(true);
            }
        });
        return isContained.get();
    }

}
