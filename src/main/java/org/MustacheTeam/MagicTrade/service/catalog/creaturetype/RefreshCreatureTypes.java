package org.MustacheTeam.MagicTrade.service.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.JpaCreatureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCreatureTypes {

   private final RealScryfallGateway realScryfallGateway;
   private final JpaCreatureTypeRepository jpaCreatureTypeRepository;

   public RefreshCreatureTypes(RealScryfallGateway realScryfallGateway, JpaCreatureTypeRepository jpaCreatureTypeRepository){
       this.realScryfallGateway = realScryfallGateway;
       this.jpaCreatureTypeRepository = jpaCreatureTypeRepository;
   }

   public void handle(String catalogElement){
       List<String> catalogCreatureType = realScryfallGateway.getScryfallCatalog(catalogElement);
       jpaCreatureTypeRepository.save(catalogCreatureType);
   }
}
