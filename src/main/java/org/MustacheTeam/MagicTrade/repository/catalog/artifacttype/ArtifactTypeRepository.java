package org.MustacheTeam.MagicTrade.repository.catalog.artifacttype;

import java.util.List;

public interface ArtifactTypeRepository {
    void save(List<String> artifactTypeToSave);
    List<String> getAllArtifactType();

}
