package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.power;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataPowerRepository extends JpaRepository<PowerEntity, Long> {
    @Query(value = "SELECT value FROM powers ORDER BY id ASC", nativeQuery = true)
    List<String> findAllPowers();
}