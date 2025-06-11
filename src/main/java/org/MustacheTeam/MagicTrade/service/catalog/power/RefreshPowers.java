package org.MustacheTeam.MagicTrade.service.catalog.power;

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
        if (powers == null || powers.isEmpty()) {
            throw new RuntimeException("Scryfall powers not found");
        }
        repository.save(powers);
    }
}
