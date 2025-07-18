package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.landtype;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.LandTypeRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaLandTypeRepository implements LandTypeRepository {

    SpringDataLandTypeRepository repository;

    public JpaLandTypeRepository(SpringDataLandTypeRepository springDataLandTypeRepository){
        this.repository = springDataLandTypeRepository;
    }

    @Override
    public void save(List<String> landTypeToSave){

        List<LandTypeEntity> landTypeList = new ArrayList<>();
        landTypeToSave.forEach(lT -> landTypeList.add(new LandTypeEntity(lT)));

        repository.saveAll(landTypeList);
    }

    @Override
    public List<String> getAllLandTypes(){
        return repository.findLandTypes();
    }

}
