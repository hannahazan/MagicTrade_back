package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ArtifactTypeRepository;
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
