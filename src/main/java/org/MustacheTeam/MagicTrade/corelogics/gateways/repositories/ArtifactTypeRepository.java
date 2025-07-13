package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import java.util.List;

public interface ArtifactTypeRepository {
    void save(List<String> artifactTypeToSave);
    List<String> getAllArtifactType();

}
