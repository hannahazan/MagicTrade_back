package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.ability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataAbilityRepository extends JpaRepository<AbilityEntity, Long> {
    @Query(value = "SELECT name from abilities",nativeQuery = true)
    List<String> findAllAbilities();
}
