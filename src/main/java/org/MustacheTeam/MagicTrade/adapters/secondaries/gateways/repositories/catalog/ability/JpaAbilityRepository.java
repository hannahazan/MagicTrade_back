package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.ability;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.AbilityRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaAbilityRepository implements AbilityRepository {

        SpringDataAbilityRepository repository;

        public JpaAbilityRepository(SpringDataAbilityRepository springDataAbilityRepository){
            this.repository = springDataAbilityRepository;
        }

        @Override
        public void save(List<String> abilitiesToSave){
           List<AbilityEntity> abilityList = new ArrayList<>();

           abilitiesToSave.forEach(a->abilityList.add(new AbilityEntity(a)));

           repository.saveAll(abilityList);
        }

        @Override
        public List<String> getAllAbilities(){
            return repository.findAllAbilities();
        }
}
