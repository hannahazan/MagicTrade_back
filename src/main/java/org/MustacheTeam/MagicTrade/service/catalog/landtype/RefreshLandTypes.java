package org.MustacheTeam.MagicTrade.service.catalog.landtype;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.JpaLandTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.LandTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshLandTypes {

    private final ScryfallGateway scryfallGateway;
    private final LandTypeRepository repository;

    public RefreshLandTypes(ScryfallGateway scryfallGateway, LandTypeRepository landTypeRepository){
        this.scryfallGateway = scryfallGateway;
        this.repository = landTypeRepository;
    }

    public void handle(String catalogElement){
        List<String> catalogLandType = scryfallGateway.getScryfallCatalog(catalogElement);
        try {
            repository.save(catalogLandType);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall land types", ex);
        }
    }

}
