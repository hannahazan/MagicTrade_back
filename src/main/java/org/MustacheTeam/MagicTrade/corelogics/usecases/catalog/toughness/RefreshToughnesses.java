package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.toughness;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ToughnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshToughnesses {
    ScryfallGateway scryfallGateway;
    ToughnessRepository repository;

    public RefreshToughnesses(ScryfallGateway scryfallGateway, ToughnessRepository toughnessRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = toughnessRepository;
    }

    public void handle(String catalogElementName){
        List<String> toughnesses = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(toughnesses);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall toughnesses", ex);
        }
    }
}
