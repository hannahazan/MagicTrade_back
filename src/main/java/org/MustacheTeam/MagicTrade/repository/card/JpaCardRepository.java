package org.MustacheTeam.MagicTrade.repository.card;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.Card;

import java.util.ArrayList;
import java.util.List;

public class JpaCardRepository implements CardRepository {

    private final SpringDataCardRepository repository;

    public JpaCardRepository(final SpringDataCardRepository springDataCardRepository){
        this.repository = springDataCardRepository;
    }

    @Override
    public void save(List<ScryfallCard> cardToSave){
        List<Card> cards = new ArrayList<>();
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
        repository.saveAll(cards);
    }

    @Override
    public List<Card> getAllCards(){
        return repository.findAll();
    }

    @Override
    public Card getCardById(String id){
        return repository.findCardById(id);
    }
}
