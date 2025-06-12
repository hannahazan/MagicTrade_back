package org.MustacheTeam.MagicTrade.repository.catalog.ability;

import org.MustacheTeam.MagicTrade.model.catalog.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataAbilityRepository extends JpaRepository<Ability, Long> {
    @Query(value = "SELECT name from abilities",nativeQuery = true)
    List<String> findAllAbilities();
}
