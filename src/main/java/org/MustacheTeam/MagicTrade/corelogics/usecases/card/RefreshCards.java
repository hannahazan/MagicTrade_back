package org.MustacheTeam.MagicTrade.corelogics.usecases.card;

import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardRepository;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardTypeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.JpaCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCards {

    private final ScryfallGateway scryfallGateway;
    private final CardRepository repository;

    public RefreshCards(ScryfallGateway scryfallGateway, CardRepository cardRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = cardRepository;
    }

    public void handle(){
        List<ScryfallCard> cards = scryfallGateway.getScryfallCards();
        try {
            repository.save(cards);
        } catch (Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall cards", ex);
        }
    }

}
