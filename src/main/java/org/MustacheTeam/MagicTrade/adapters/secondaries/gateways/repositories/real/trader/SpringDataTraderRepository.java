package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trader;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SpringDataTraderRepository extends JpaRepository<UserEntity, Long> {

    @Query("""
        SELECT new org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview(
            u.id,
            u.pseudo,
            u.city,
            u.country,
            u.department,
            COUNT(c.id)
        )
        FROM UserEntity u
        LEFT JOIN u.collections c
        GROUP BY u.id, u.pseudo, u.city, u.country, u.department
        """)
    List<TraderPreview> findAllWithCollections();
}
