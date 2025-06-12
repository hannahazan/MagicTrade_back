package org.MustacheTeam.MagicTrade.repository.catalog.landtype;

import org.MustacheTeam.MagicTrade.model.catalog.LandType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataLandTypeRepository extends JpaRepository<LandType,Long> {
    @Query(value="SELECT land_type FROM land_types",nativeQuery = true)
    List<String> findLandTypes();
}
