package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.cardname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringdataCardNameRepository extends JpaRepository<CardNameEntity, Long> {
    @Query(value = "SELECT name from card_names", nativeQuery = true)
    List<String> findAllCardNames();
}
