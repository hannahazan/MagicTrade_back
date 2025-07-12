package org.MustacheTeam.MagicTrade.service.catalog.ability;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.ability.AbilityRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.ability.JpaAbilityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllAbilities {
        AbilityRepository repository;

        public GetAllAbilities(AbilityRepository AbilityRepository){
            this.repository = AbilityRepository;
        }

        public Filters handle(){
            List<String> filtersJpa = repository.getAllAbilities();
            return new Filters(filtersJpa);
        }
}
