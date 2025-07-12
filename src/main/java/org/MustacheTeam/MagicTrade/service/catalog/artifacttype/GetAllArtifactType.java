package org.MustacheTeam.MagicTrade.service.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.ArtifactTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.JpaArtifactTypeRepository;
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
