package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataCardTypeRepository extends JpaRepository<CardTypeEntity, Long> {
    @Query(value = "SELECT name from card_types ", nativeQuery = true)
    List<String> findAllCardTypes();
}