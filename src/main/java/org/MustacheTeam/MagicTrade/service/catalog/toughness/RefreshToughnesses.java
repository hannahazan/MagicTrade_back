package org.MustacheTeam.MagicTrade.service.catalog.toughness;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.toughness.JpaToughnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshToughnesses {
    RealScryfallGateway realScryfallGateway;
    JpaToughnessRepository repository;

    public RefreshToughnesses(RealScryfallGateway realScryfallGateway, JpaToughnessRepository jpaToughnessRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.repository = jpaToughnessRepository;
    }

    public void handle(String catalogElementName){
        List<String> toughnesses = realScryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(toughnesses);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall toughnesses", ex);
        }
    }
}
