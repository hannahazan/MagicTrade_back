package org.MustacheTeam.MagicTrade.service.catalog.cardType;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.JpaCardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCardTypes {
    RealScryfallGateway realScryfallGateway;
    JpaCardTypeRepository repository;

    public RefreshCardTypes(RealScryfallGateway realScryfallGateway, JpaCardTypeRepository jpaCardTypeRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.repository = jpaCardTypeRepository;
    }

    public void handle(String catalogElementName){
        List<String> cardTypes = realScryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(cardTypes);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall card types", ex);
        }
    }
}
