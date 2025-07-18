package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.ArtifactTypeRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaArtifactTypeRepository implements ArtifactTypeRepository {

    SpringDataArtifactTypeRepository repository;

    public JpaArtifactTypeRepository(SpringDataArtifactTypeRepository springDataArtifactTypeRepository){
        this.repository = springDataArtifactTypeRepository;
    }

    @Override
    public void save(List<String> ArtifactTypeToSave){
        List<ArtifactTypeEntity> artifactTypeList = new ArrayList<>();

        ArtifactTypeToSave.forEach(a->artifactTypeList.add(new ArtifactTypeEntity(a)));

        repository.saveAll(artifactTypeList);
    }

    @Override
    public List<String> getAllArtifactType(){
        return repository.findAllArtifactType();
    }

}
