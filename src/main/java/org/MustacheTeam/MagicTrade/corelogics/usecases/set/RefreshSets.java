package org.MustacheTeam.MagicTrade.corelogics.usecases.set;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.set.JpaSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshSets {

    RealScryfallGateway realScryfallGateway;
    JpaSetRepository jpaSetRepository;

    public RefreshSets(RealScryfallGateway realScryfallGateway, JpaSetRepository jpaSetRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaSetRepository = jpaSetRepository;
    }

    public void handle(){
        List<ScryfallSet> sets = realScryfallGateway.getScryfallSets();
        try {
            jpaSetRepository.save(sets);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall sets", ex);
        }
    }
}
