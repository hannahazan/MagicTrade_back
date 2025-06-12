package org.MustacheTeam.MagicTrade.service.catalog.ability;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.ability.JpaAbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshAbilities {

    RealScryfallGateway realScryfallGateway;
    JpaAbilityRepository jpaAbilityRepository;

    public RefreshAbilities(RealScryfallGateway realScryfallGateway, JpaAbilityRepository jpaAbilityRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaAbilityRepository = jpaAbilityRepository;
    }

    public void handle(String catalogElementName){
        List<String> abilitiesList = realScryfallGateway.getScryfallCatalog(catalogElementName);

        jpaAbilityRepository.save(abilitiesList);
    }
}
