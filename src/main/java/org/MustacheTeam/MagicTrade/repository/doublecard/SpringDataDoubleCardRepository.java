package org.MustacheTeam.MagicTrade.repository.doublecard;

import org.MustacheTeam.MagicTrade.model.DoubleCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface SpringDataDoubleCardRepository extends JpaRepository<DoubleCard, String> {
}
