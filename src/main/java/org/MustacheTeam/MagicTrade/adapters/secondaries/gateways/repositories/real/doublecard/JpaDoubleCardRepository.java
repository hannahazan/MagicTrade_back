package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class JpaDoubleCardRepository implements DoubleCardRepository {

    private final SpringDataDoubleCardRepository repository;

    public JpaDoubleCardRepository(SpringDataDoubleCardRepository springDataDoubleCardRepository){
        this.repository = springDataDoubleCardRepository;
    }

    @Override
    public void save(List<ScryfallCard> cardsToSave){
        List<DoubleCardEntity> doubleCards = new ArrayList<>();
        cardsToSave.forEach(card->{
            boolean isPaper = false;
            for(int i=0;i<card.games().size();i++){
                if (card.games().get(i).equals("paper")) {
                    isPaper = true;
                    break;
                }
            }
            if(isPaper && !Objects.isNull(card.card_faces())){
                card.card_faces().stream().map(c->doubleCards.add(new DoubleCardEntity(UUID.randomUUID().toString() + Math.random(),
                        card.id(),c.name(),c.mana_cost(),c.type_line(),c.oracle_text(),c.power(),c.toughness(),c.image_uris() != null? c.image_uris().normal():null,c.image_uris()!=null? c.image_uris().art_crop():null
                ))).toList();
            }
        });
        repository.saveAll(doubleCards);
    }

    @Override
    public DoubleCardList getAllDoubleCards(){
        List<DoubleCard> doubleCards = new ArrayList<>();
        repository.findAll().forEach(dc-> doubleCards.add(new DoubleCard(dc.getId(), dc.getCardId(), dc.getName(),
                dc.getManaCost(), dc.getTypeLine(), dc.getText(), dc.getPower(), dc.getToughness(), dc.getImageSizeNormal(), dc.getImageSizeArtCrop())));

        return new DoubleCardList(doubleCards);
    }

}
