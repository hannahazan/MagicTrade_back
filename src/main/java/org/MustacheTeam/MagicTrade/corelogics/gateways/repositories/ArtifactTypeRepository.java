package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.List;

public interface ArtifactTypeRepository {
    void save(List<String> artifactTypeToSave);
    Filters getAllArtifactType();

}
