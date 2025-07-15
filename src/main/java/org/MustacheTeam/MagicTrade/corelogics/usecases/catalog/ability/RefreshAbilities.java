package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshAbilities {

    ScryfallGateway ScryfallRepository;
    AbilityRepository repository;

    public RefreshAbilities(ScryfallGateway scryfallGateway, AbilityRepository abilityRepository){
        this.ScryfallRepository = scryfallGateway;
        this.repository = abilityRepository;
    }

    public void handle(String catalogElementName){
        List<String> abilitiesList = ScryfallRepository.getScryfallCatalog(catalogElementName);
        try {
            repository.save(abilitiesList);
        } catch (Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall abilities", ex);
        }
    }
}
