package org.MustacheTeam.MagicTrade.service.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.ArtifactTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.artifacttype.JpaArtifactTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshArtifactType {
    private final ArtifactTypeRepository repository;
    private final ScryfallGateway scryfallGateway;

    public RefreshArtifactType(ArtifactTypeRepository artifactTypeRepository, ScryfallGateway scryfallGateway){
        this.repository= artifactTypeRepository;
        this.scryfallGateway = scryfallGateway;
    }

    public void handle(String catalogElementName){
        List<String> artifactTypes = scryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            repository.save(artifactTypes);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall artifact types", ex);
        }
    }
}
