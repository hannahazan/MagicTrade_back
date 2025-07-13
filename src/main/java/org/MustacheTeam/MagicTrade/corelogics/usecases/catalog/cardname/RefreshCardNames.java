package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardname;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCardNames {
    ScryfallGateway scryfallGateway;
    CardNameRepository repository;

    public RefreshCardNames(ScryfallGateway scryfallGateway, CardNameRepository cardNameRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = cardNameRepository;
    }

    public void handle(String catalogElementName){
        List<String> cardNames = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(cardNames);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall card names", ex);
        }
    }

}
