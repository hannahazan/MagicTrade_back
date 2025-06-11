package org.MustacheTeam.MagicTrade.repository.cardType;

import org.MustacheTeam.MagicTrade.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCardTypeRepository extends JpaRepository<CardType, Long> {
}