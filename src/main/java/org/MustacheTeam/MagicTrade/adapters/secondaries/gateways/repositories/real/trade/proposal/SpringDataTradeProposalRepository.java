package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataTradeProposalRepository extends JpaRepository<TradeProposalEntity, Long> {
    @Query("select p from TradeProposalEntity p where p.trade.id = :id order by p.createdAt desc")
    List<TradeProposalEntity> findAllByTradeId(Long id);
}
