package org.MustacheTeam.MagicTrade.service;

import org.MustacheTeam.MagicTrade.model.DoubleCard;
import org.MustacheTeam.MagicTrade.repository.JpaDoubleCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllDoubleCards {

    private final JpaDoubleCardRepository JpaDoubleCardRepository;

    public GetAllDoubleCards(JpaDoubleCardRepository jpaDoubleCardRepository){
        this.JpaDoubleCardRepository =jpaDoubleCardRepository;
    }

    public List<DoubleCard> handle(){
        return JpaDoubleCardRepository.getAllDoubleCards();
    }
}
