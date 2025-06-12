package org.MustacheTeam.MagicTrade.repository.catalog.ability;

import org.MustacheTeam.MagicTrade.model.catalog.Ability;

import java.util.ArrayList;
import java.util.List;

public class JpaAbilityRepository implements AbilityRepository {

        SpringDataAbilityRepository repository;

        public JpaAbilityRepository(SpringDataAbilityRepository springDataAbilityRepository){
            this.repository = springDataAbilityRepository;
        }

        @Override
        public void save(List<String> abilitiesToSave){
           List<Ability> abilityList = new ArrayList<>();

           abilitiesToSave.forEach(a->abilityList.add(new Ability(a)));

           repository.saveAll(abilityList);
        }

        @Override
        public List<String> getAllAbilities(){
            return repository.findAllAbilities();
        }
}
