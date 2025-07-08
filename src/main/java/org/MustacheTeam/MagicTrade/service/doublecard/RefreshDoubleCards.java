package org.MustacheTeam.MagicTrade.service.doublecard;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.doublecard.JpaDoubleCardRepository;
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
