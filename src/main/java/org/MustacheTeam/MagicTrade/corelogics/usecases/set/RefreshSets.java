package org.MustacheTeam.MagicTrade.corelogics.usecases.set;

import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.SetRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.set.JpaSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshSets {

    ScryfallGateway scryfallGateway;
    SetRepository repository;

    public RefreshSets(ScryfallGateway scryfallGateway, SetRepository setRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = setRepository;
    }

    public void handle(){
        List<ScryfallSet> sets = scryfallGateway.getScryfallSets();
        try {
            repository.save(sets);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall sets", ex);
        }
    }
}
