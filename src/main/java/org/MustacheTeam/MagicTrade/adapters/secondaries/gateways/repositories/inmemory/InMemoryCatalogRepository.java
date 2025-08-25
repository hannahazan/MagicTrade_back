package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.*;
import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCatalogRepository implements AbilityRepository, ArtifactTypeRepository, CardNameRepository, CardTypeRepository, CreatureTypeRepository,
 EnchantmentTypeRepository, LandTypeRepository, PowerRepository, ToughnessRepository{
        private List<String> filterList = new ArrayList<>();

    @Override
    public Filters getAllAbilities(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllArtifactType(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllCardNames(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllCardTypes(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllCreatureTypes(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllLandTypes(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllEnchantmentTypes(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllPowers(){
        return new Filters(filterList);
    }

    @Override
    public Filters getAllToughnesses(){
        return new Filters(filterList);
    }

    @Override
    public void save(List<String> abilities){
       filterList.addAll(abilities);
    }
    
    public void feedFilters(List<String> filters){
        filterList.addAll(filters);
    }
}
