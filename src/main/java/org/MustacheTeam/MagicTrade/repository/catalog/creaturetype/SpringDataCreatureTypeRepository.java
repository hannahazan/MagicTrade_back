package org.MustacheTeam.MagicTrade.repository.catalog.creaturetype;

import org.MustacheTeam.MagicTrade.model.catalog.CreatureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCreatureTypeRepository extends JpaRepository<CreatureType, Long> {

}
