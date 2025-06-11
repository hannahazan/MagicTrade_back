package org.MustacheTeam.MagicTrade.repository.catalog.cardType;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCardTypeRepository extends JpaRepository<CardType, Long> {
}