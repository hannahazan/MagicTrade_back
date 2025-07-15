package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface SpringDataDoubleCardRepository extends JpaRepository<DoubleCardEntity, String> {
}
