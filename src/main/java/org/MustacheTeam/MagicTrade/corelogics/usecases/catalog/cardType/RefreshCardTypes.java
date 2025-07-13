package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardType;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCardTypes {
    ScryfallGateway scryfallGateway;
    CardTypeRepository repository;

    public RefreshCardTypes(ScryfallGateway scryfallGateway, CardTypeRepository cardTypeRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = cardTypeRepository;
    }

    public void handle(String catalogElementName){
        List<String> cardTypes = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(cardTypes);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall card types", ex);
        }
    }
}
