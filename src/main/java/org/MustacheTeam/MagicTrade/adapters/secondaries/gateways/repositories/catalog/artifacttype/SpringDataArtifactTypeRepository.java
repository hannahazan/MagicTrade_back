package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.artifacttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataArtifactTypeRepository extends JpaRepository<ArtifactTypeEntity, Long> {
    @Query(value="SELECT type from artifact_types",nativeQuery = true)
    List<String> findAllArtifactType();
}
