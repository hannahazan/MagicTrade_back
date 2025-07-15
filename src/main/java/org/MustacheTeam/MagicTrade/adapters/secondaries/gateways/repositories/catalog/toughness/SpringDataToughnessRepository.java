package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.toughness;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataToughnessRepository extends JpaRepository<ToughnessEntity, Long> {

    @Query(value = "SELECT value FROM toughnesses ORDER BY id ASC", nativeQuery = true)
    List<String> findAllToughnesses();
}