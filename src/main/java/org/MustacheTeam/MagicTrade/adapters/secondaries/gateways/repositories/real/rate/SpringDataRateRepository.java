package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataRateRepository extends JpaRepository<RateEntity, Long> {
    @Query("SELECT AVG(r.rate) FROM RateEntity r WHERE r.userRated.id = :ratedUserId")
    Double findAvgRate(@Param("ratedUserId") Long ratedUserId );

    List<RateEntity> findByUserRatedId(Long ratedId);
}
