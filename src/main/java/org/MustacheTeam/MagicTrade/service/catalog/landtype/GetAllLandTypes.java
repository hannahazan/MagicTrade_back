package org.MustacheTeam.MagicTrade.service.catalog.landtype;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.JpaLandTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.LandTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLandTypes {
    private final LandTypeRepository repository;

    public GetAllLandTypes(LandTypeRepository landTypeRepository){
        this.repository = landTypeRepository;
    }

    public Filters handle(){
        List<String> landTypes = repository.getAllLandTypes();
        return new Filters(landTypes);
    }
}
