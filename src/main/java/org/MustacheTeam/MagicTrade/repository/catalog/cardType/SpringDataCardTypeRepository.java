package org.MustacheTeam.MagicTrade.repository.catalog.cardType;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataCardTypeRepository extends JpaRepository<CardType, Long> {
    @Query(value = "SELECT name from card_types ", nativeQuery = true)
    List<String> findAllCardTypes();
}