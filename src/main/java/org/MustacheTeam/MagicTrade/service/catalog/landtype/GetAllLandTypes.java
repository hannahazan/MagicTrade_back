package org.MustacheTeam.MagicTrade.service.catalog.landtype;

import org.MustacheTeam.MagicTrade.repository.catalog.landtype.JpaLandTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLandTypes {
    private final JpaLandTypeRepository jpaLandTypeRepository;

    public GetAllLandTypes(JpaLandTypeRepository jpaLandTypeRepository){
        this.jpaLandTypeRepository = jpaLandTypeRepository;
    }

    public List<String> handle(){
        return jpaLandTypeRepository.getAllLandTypes();
    }
}
