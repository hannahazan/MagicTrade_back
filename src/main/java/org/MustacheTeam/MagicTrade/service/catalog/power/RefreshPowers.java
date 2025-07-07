package org.MustacheTeam.MagicTrade.service.catalog.power;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.power.JpaPowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshPowers {
    RealScryfallGateway realScryfallGateway;
    JpaPowerRepository repository;

    public RefreshPowers(RealScryfallGateway realScryfallGateway, JpaPowerRepository jpaPowerRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.repository = jpaPowerRepository;
    }

    public void handle(String catalogElementName){
        List<String> powers = realScryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(powers);
        } catch( Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall powers", ex);
        }
    }
}
