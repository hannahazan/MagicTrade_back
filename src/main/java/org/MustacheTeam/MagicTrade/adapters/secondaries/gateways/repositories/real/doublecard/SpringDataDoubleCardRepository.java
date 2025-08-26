package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface SpringDataDoubleCardRepository extends JpaRepository<DoubleCardEntity, Long> {
    @Query(value = "SELECT * FROM double_cards", nativeQuery = true)
    List<DoubleCardEntity> findAllDoubleCard();
}
