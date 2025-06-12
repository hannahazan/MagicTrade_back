package org.MustacheTeam.MagicTrade.repository.catalog.cardname;

import org.MustacheTeam.MagicTrade.model.catalog.CardName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringdataCardNameRepository extends JpaRepository<CardName, Long> {
    @Query(value = "SELECT name from card_names", nativeQuery = true)
    List<String> findAllCardNames();
}
