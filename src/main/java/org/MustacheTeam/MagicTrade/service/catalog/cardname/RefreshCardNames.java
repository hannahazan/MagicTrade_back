package org.MustacheTeam.MagicTrade.service.catalog.cardname;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.cardname.CardNameRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardname.JpaCardNameRepository;
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
