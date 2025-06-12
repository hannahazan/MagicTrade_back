package org.MustacheTeam.MagicTrade.repository.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.model.catalog.CreatureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataCreatureTypeRepository extends JpaRepository<CreatureType, Long> {
    @Query(value="SELECT type FROM creature_types",nativeQuery = true)
    List<String> findAllCreatureTypes();
}
