package org.MustacheTeam.MagicTrade.service.catalog.cardType;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.CardTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.JpaCardTypeRepository;
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
