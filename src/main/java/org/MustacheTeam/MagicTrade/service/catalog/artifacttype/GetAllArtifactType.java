package org.MustacheTeam.MagicTrade.service.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.JpaArtifactTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllArtifactType {
    private final JpaArtifactTypeRepository jpaArtifactTypeRepository;

    public GetAllArtifactType(JpaArtifactTypeRepository jpaArtifactTypeRepository){
        this.jpaArtifactTypeRepository = jpaArtifactTypeRepository;
    }

    public List<String> handle(){
        return jpaArtifactTypeRepository.getAllArtifactType();
    }
}
