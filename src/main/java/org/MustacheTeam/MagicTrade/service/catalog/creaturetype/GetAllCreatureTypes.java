package org.MustacheTeam.MagicTrade.service.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.CreatureTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.JpaCreatureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCreatureTypes {

    private final CreatureTypeRepository repository;

    public GetAllCreatureTypes(CreatureTypeRepository creatureTypeRepository){
        this.repository = creatureTypeRepository;
    }

    public Filters handle(){
        List<String> creatureTypeJpa = repository.getAllCreatureTypes();
        return new Filters(creatureTypeJpa);
    }

}
