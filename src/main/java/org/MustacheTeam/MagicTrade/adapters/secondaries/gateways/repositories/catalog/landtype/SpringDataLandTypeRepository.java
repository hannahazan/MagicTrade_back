package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.landtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataLandTypeRepository extends JpaRepository<LandTypeEntity,Long> {
    @Query(value="SELECT type FROM land_types",nativeQuery = true)
    List<String> findLandTypes();
}
