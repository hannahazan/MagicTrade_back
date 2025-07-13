package org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.JpaDoubleCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshDoubleCards {

    private final RealScryfallGateway realScryfallGateway;
    private final JpaDoubleCardRepository jpaDoubleCardRepository;

    public RefreshDoubleCards(RealScryfallGateway realScryfallGateway,JpaDoubleCardRepository jpaDoubleCardRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaDoubleCardRepository = jpaDoubleCardRepository;
    }

    public void handle(){
        List<ScryfallCard> cards = realScryfallGateway.getScryfallCards();
        try {
            jpaDoubleCardRepository.save(cards);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall double cards", ex);
        }
    }

}
