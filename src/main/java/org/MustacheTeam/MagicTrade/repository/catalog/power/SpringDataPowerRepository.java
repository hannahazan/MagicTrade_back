package org.MustacheTeam.MagicTrade.repository.catalog.power;

import org.MustacheTeam.MagicTrade.model.catalog.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataPowerRepository extends JpaRepository<Power, Long> {
    @Query(value = "SELECT value FROM powers ORDER BY id ASC", nativeQuery = true)
    List<String> findAllPowers();
}