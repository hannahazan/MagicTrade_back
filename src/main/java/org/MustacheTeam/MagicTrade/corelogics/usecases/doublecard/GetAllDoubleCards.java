package org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.JpaDoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllDoubleCards {

    private final DoubleCardRepository repository;

    public GetAllDoubleCards(DoubleCardRepository doubleCardRepository){
        this.repository = doubleCardRepository;
    }

    public DoubleCardList handle(){
        List<DoubleCard> doubleCards = new ArrayList<>();
        repository.getAllDoubleCards().forEach(dc-> doubleCards.add(new DoubleCard(dc.getId(), dc.getCardId(), dc.getName(),
                dc.getManaCost(), dc.getTypeLine(), dc.getText(), dc.getPower(), dc.getToughness(), dc.getImageSizeNormal(), dc.getImageSizeArtCrop())));

        return new DoubleCardList(doubleCards);
    }
}
