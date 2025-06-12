package org.MustacheTeam.MagicTrade.repository.catalog.landtype;

import org.MustacheTeam.MagicTrade.model.catalog.LandType;

import java.util.ArrayList;
import java.util.List;

public class JpaLandTypeRepository implements LandTypeRepository {

    SpringDataLandTypeRepository repository;

    public JpaLandTypeRepository(SpringDataLandTypeRepository springDataLandTypeRepository){
        this.repository = springDataLandTypeRepository;
    }

    public void save(List<String> landTypeToSave){

        List<LandType> landTypeList = new ArrayList<>();
        landTypeToSave.forEach(lT -> landTypeList.add(new LandType(lT)));

        repository.saveAll(landTypeList);
    }

    public List<String> getAllLandTypes(){
        return repository.findLandTypes();
    }

}
