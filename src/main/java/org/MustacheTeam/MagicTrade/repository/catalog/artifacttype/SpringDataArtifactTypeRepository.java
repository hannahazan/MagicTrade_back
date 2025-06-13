package org.MustacheTeam.MagicTrade.repository.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.model.catalog.ArtifactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataArtifactTypeRepository extends JpaRepository<ArtifactType, Long> {
    @Query(value="SELECT type from artifact_types",nativeQuery = true)
    List<String> findAllArtifactType();
}
