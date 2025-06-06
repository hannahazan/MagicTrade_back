package org.MustacheTeam.MagicTrade.repository.set;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.model.Set;

import java.util.ArrayList;
import java.util.List;

public class JpaSetRepository implements SetRepository{

    private final SpringDataSetRepository repository;

     public JpaSetRepository(SpringDataSetRepository springDataSetRepository){
         this.repository = springDataSetRepository;
     }

     public void save(List<ScryfallSet> setToSave){
         List<Set> setList = new ArrayList<>();
         setToSave.forEach(set->{
             if(!set.digital()){
                 setList.add(new Set(set.id(),set.name(),set.icon_svg_uri()));
             }
         });
         repository.saveAll(setList);
     }
}
