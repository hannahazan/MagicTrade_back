package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTradeRepository extends JpaRepository<TradeEntity, Long> {
}
