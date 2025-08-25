package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InMemoryDoublecardRepository implements DoubleCardRepository {

    List<DoubleCard> doubleCardList = new ArrayList<>();

    @Override
    public void save(List<ScryfallCard> cardsToSave){
        cardsToSave.forEach(card->{
            boolean isPaper = false;
            for(int i=0;i<card.games().size();i++){
                if (card.games().get(i).equals("paper")) {
                    isPaper = true;
                    break;
                }
            }
            if(isPaper && !Objects.isNull(card.card_faces())){
                card.card_faces().stream().map(c->doubleCardList.add(new DoubleCard(UUID.randomUUID().toString() + Math.random(),
                        card.id(),c.name(),c.mana_cost(),c.type_line(),c.oracle_text(),c.power(),c.toughness(),c.image_uris() != null? c.image_uris().normal():null,c.image_uris()!=null? c.image_uris().art_crop():null
                ))).toList();
            }
        });
    }

    @Override
    public DoubleCardList getAllDoubleCards(){
        return new DoubleCardList(doubleCardList);
    }

    public void feedDoubleCardList(List<DoubleCard> doubleCards){
        doubleCardList.addAll(doubleCards);
    }
}
