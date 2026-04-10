package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface SpringDataCardRepository extends JpaRepository<CardEntity, String> {
    @Query(value = "SELECT COUNT(*) from cards", nativeQuery = true)
    int findTotalCardObject();
}
