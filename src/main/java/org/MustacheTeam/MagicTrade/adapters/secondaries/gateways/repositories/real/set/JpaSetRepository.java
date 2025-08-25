package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.set;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.SetRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaSetRepository implements SetRepository {

    private final SpringDataSetRepository repository;

     public JpaSetRepository(SpringDataSetRepository springDataSetRepository){
         this.repository = springDataSetRepository;
     }

     public void save(List<ScryfallSet> setToSave){
         List<SetEntity> setList = new ArrayList<>();
         setToSave.forEach(set->{
             if(!set.digital()){
                 setList.add(new SetEntity(set.id(),set.name(),set.icon_svg_uri()));
             }
         });
         repository.saveAll(setList);
     }
}
