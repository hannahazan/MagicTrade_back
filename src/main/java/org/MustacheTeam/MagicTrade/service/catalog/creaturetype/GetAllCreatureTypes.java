package org.MustacheTeam.MagicTrade.service.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.JpaCreatureTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCreatureTypes {

    private final JpaCreatureTypeRepository jpaCreatureTypeRepository;

    public GetAllCreatureTypes(JpaCreatureTypeRepository jpaCreatureTypeRepository){
        this.jpaCreatureTypeRepository = jpaCreatureTypeRepository;
    }

    public List<String> handle(){
       return jpaCreatureTypeRepository.getAllCreatureTypes();
    }

}
