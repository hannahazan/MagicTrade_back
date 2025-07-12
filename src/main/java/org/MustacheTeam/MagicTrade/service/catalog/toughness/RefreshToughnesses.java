package org.MustacheTeam.MagicTrade.service.catalog.toughness;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.JpaToughnessRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.ToughnessRepository;
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
