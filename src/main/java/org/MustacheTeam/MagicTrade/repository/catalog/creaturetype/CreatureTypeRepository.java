package org.MustacheTeam.MagicTrade.repository.catalog.creaturetype;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureTypeRepository {
    void save(List<String> creatureTypeToSave);
    List<String> getAllCreatureTypes();
}
