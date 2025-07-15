package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CreatureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCreatureTypes {

   private final ScryfallGateway scryfallGateway;
   private final CreatureTypeRepository repository;

   public RefreshCreatureTypes(ScryfallGateway scryfallGateway, CreatureTypeRepository creatureTypeRepository){
       this.scryfallGateway = scryfallGateway;
       this.repository = creatureTypeRepository;
   }

   public void handle(String catalogElement){
       List<String> catalogCreatureType = scryfallGateway.getScryfallCatalog(catalogElement);
       try {
           repository.save(catalogCreatureType);
       } catch(Exception ex) {
           throw new ScryfallPersistenceException("Failed to persist Scryfall creature types", ex);
       }
   }
}
