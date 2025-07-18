package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;

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
    public List<DoubleCardEntity> getAllDoubleCards(){
        return repository.findAll();
    }

}
