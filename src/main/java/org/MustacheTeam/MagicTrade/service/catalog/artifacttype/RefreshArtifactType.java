package org.MustacheTeam.MagicTrade.service.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.JpaArtifactTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshArtifactType {
    private final JpaArtifactTypeRepository jpaArtifactTypeRepository;
    private final RealScryfallGateway realScryfallGateway;

    public RefreshArtifactType(JpaArtifactTypeRepository jpaArtifactTypeRepository, RealScryfallGateway realScryfallGateway){
        this.jpaArtifactTypeRepository = jpaArtifactTypeRepository;
        this.realScryfallGateway = realScryfallGateway;
    }

    public void handle(String catalogElementName){
        List<String> artifactTypes = realScryfallGateway.getScryfallCatalog(catalogElementName);

        jpaArtifactTypeRepository.save(artifactTypes);
    }
}
