package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CreatureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCreatureTypes {

    private final CreatureTypeRepository repository;

    public GetAllCreatureTypes(CreatureTypeRepository creatureTypeRepository){
        this.repository = creatureTypeRepository;
    }

    public Filters handle(){
        return repository.getAllCreatureTypes();
    }

}
