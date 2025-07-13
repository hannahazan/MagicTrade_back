package org.MustacheTeam.MagicTrade.corelogics.usecases.card;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.JpaCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCards {

    private final RealScryfallGateway realScryfallGateway;
    private final JpaCardRepository jpaCardRepository;

    public RefreshCards(RealScryfallGateway realScryfallGateway,JpaCardRepository cardRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaCardRepository = cardRepository;
    }

    public void handle(){
        List<ScryfallCard> cards = realScryfallGateway.getScryfallCards();
        try {
            jpaCardRepository.save(cards);
        } catch (Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall cards", ex);
        }
    }

}
