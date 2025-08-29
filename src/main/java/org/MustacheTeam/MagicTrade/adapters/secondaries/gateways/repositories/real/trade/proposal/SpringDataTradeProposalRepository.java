package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataTradeProposalRepository extends JpaRepository<TradeProposalEntity, Long> {
    @Query("select distinct p " +
            "from TradeProposalEntity p " +
            "left join fetch p.tradeItemProposalList i " +
            "left join fetch i.collectionCard c " +
            "where p.trade.id = :tradeId " +
            "order by p.createdAt desc")
    List<TradeProposalEntity> findAllWithItemsByTradeId(
            @Param("tradeId") Long tradeId
    );
}
