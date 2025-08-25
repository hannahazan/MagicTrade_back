package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.creaturetype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataCreatureTypeRepository extends JpaRepository<CreatureTypeEntity, Long> {
    @Query(value="SELECT type FROM creature_types",nativeQuery = true)
    List<String> findAllCreatureTypes();
}
