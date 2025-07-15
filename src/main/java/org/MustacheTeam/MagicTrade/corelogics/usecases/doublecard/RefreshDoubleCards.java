package org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard;

import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.JpaDoubleCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshDoubleCards {

    private final ScryfallGateway scryfallGateway;
    private final DoubleCardRepository repository;

    public RefreshDoubleCards(ScryfallGateway scryfallGateway,DoubleCardRepository doubleCardRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = doubleCardRepository;
    }

    public void handle(){
        List<ScryfallCard> cards = scryfallGateway.getScryfallCards();
        try {
            repository.save(cards);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall double cards", ex);
        }
    }

}
