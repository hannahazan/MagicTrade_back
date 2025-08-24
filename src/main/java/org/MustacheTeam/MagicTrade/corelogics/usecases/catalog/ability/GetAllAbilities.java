package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.ability;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAbilities {
        AbilityRepository repository;

        public GetAllAbilities(AbilityRepository AbilityRepository){
            this.repository = AbilityRepository;
        }

        public Filters handle(){
            return repository.getAllAbilities();
        }
}
