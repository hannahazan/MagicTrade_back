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
    public DoubleCardList getAllDoubleCards(){
        List<DoubleCard> doubleCards = new ArrayList<>();
        repository.findAll().forEach(dc-> doubleCards.add(new DoubleCard(dc.getId(), dc.getCard().getId(), dc.getName(),
                dc.getManaCost(), dc.getTypeLine(), dc.getText(), dc.getPower(), dc.getToughness(), dc.getImageSizeNormal(), dc.getImageSizeArtCrop())));

        return new DoubleCardList(doubleCards);
    }

}
