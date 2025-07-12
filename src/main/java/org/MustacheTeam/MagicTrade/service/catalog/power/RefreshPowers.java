package org.MustacheTeam.MagicTrade.service.catalog.power;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.power.JpaPowerRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.power.PowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshPowers {
    ScryfallGateway scryfallGateway;
    PowerRepository repository;

    public RefreshPowers(ScryfallGateway scryfallGateway, PowerRepository powerRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = powerRepository;
    }

    public void handle(String catalogElementName){
        List<String> powers = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(powers);
        } catch( Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall powers", ex);
        }
    }
}
