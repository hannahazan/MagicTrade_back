package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ArtifactTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllArtifactType {
    private final ArtifactTypeRepository repository;

    public GetAllArtifactType(ArtifactTypeRepository artifactTypeRepository){
        this.repository = artifactTypeRepository;
    }

    public Filters handle(){
        List<String> artifactTypesJpa = repository.getAllArtifactType();
        return new Filters(artifactTypesJpa);
    }
}
