package org.MustacheTeam.MagicTrade.service.catalog.cardname;

import org.MustacheTeam.MagicTrade.repository.catalog.cardname.JpaCardNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCardNames {

    private final JpaCardNameRepository jpaCardNameRepository;

    public GetAllCardNames(JpaCardNameRepository jpaCardNameRepository){
        this.jpaCardNameRepository =jpaCardNameRepository;
    }

    public List<String> handle(){
        return jpaCardNameRepository.getAllCardNames();
    }


}
