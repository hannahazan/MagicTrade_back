package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CreatureTypeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.ArrayList;
import java.util.List;

public class JpaCreatureTypeRepository implements CreatureTypeRepository {

    SpringDataCreatureTypeRepository repository;

    public JpaCreatureTypeRepository(SpringDataCreatureTypeRepository springDataCreatureTypeRepository){
        this.repository= springDataCreatureTypeRepository;
    }

    @Override
    public void save(List<String> creatureTypesToSave) {

        List<CreatureTypeEntity> creatureTypeList = new ArrayList<>();
        creatureTypesToSave.forEach(cT -> creatureTypeList.add(new CreatureTypeEntity(cT)));

        repository.saveAll(creatureTypeList);

    }

    @Override
    public Filters getAllCreatureTypes(){
        return new Filters(repository.findAllCreatureTypes());
    }
}
