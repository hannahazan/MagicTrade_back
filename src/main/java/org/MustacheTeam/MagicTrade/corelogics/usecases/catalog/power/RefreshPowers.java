package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.power;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.PowerRepository;
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
