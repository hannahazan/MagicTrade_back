package org.MustacheTeam.MagicTrade.service.catalog.landtype;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.JpaLandTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshLandTypes {

    private final RealScryfallGateway realScryfallGateway;
    private final JpaLandTypeRepository jpaLandTypeRepository;

    public RefreshLandTypes(RealScryfallGateway realScryfallGateway, JpaLandTypeRepository jpaLandTypeRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaLandTypeRepository = jpaLandTypeRepository;
    }

    public void handle(String catalogElement){
        List<String> catalogLandType = realScryfallGateway.getScryfallCatalog(catalogElement);
        jpaLandTypeRepository.save(catalogLandType);
    }

}
