package org.MustacheTeam.MagicTrade.repository.card;

import org.MustacheTeam.MagicTrade.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface SpringDataCardRepository extends JpaRepository<Card, String> {
    List<Card> findAll();
}
