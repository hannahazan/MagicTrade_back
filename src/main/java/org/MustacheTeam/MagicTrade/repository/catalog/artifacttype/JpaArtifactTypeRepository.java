package org.MustacheTeam.MagicTrade.repository.catalog.artifacttype;

import org.MustacheTeam.MagicTrade.model.catalog.ArtifactType;

import java.util.ArrayList;
import java.util.List;

public class JpaArtifactTypeRepository implements ArtifactTypeRepository{

    SpringDataArtifactTypeRepository repository;

    public JpaArtifactTypeRepository(SpringDataArtifactTypeRepository springDataArtifactTypeRepository){
        this.repository = springDataArtifactTypeRepository;
    }

    @Override
    public void save(List<String> ArtifactTypeToSave){
        List<ArtifactType> artifactTypeList = new ArrayList<>();

        ArtifactTypeToSave.forEach(a->artifactTypeList.add(new ArtifactType(a)));

        repository.saveAll(artifactTypeList);
    }

    @Override
    public List<String> getAllArtifactType(){
        return repository.findAllArtifactType();
    }

}
