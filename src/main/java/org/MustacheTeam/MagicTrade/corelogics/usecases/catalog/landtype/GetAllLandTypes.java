package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.landtype;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.LandTypeRepository;
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
