package org.MustacheTeam.MagicTrade.repository.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.model.catalog.CreatureType;

import java.util.ArrayList;
import java.util.List;

public class JpaCreatureTypeRepository implements CreatureTypeRepository {

    SpringDataCreatureTypeRepository repository;

    public JpaCreatureTypeRepository(SpringDataCreatureTypeRepository springDataCreatureTypeRepository){
        this.repository= springDataCreatureTypeRepository;
    }

    @Override
    public void save(List<String> creatureTypesToSave) {

        List<CreatureType> creatureTypeList = new ArrayList<>();
        creatureTypesToSave.forEach(cT -> creatureTypeList.add(new CreatureType(cT)));

        repository.saveAll(creatureTypeList);

    }

}
