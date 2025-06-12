package org.MustacheTeam.MagicTrade.service.catalog.ability;

import org.MustacheTeam.MagicTrade.repository.catalog.ability.JpaAbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAbilities {
        JpaAbilityRepository jpaAbilityRepository;

        public GetAllAbilities(JpaAbilityRepository jpaAbilityRepository){
            this.jpaAbilityRepository = jpaAbilityRepository;
        }

        public List<String> handle(){
            return jpaAbilityRepository.getAllAbilities();
        }
}
