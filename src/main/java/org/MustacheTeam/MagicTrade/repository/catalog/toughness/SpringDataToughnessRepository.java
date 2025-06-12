package org.MustacheTeam.MagicTrade.repository.catalog.toughness;

import org.MustacheTeam.MagicTrade.model.catalog.Toughness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataToughnessRepository extends JpaRepository<Toughness, Long> {

    @Query(value = "SELECT value FROM toughnesses ORDER BY id ASC", nativeQuery = true)
    List<String> findAllToughnesses();
}