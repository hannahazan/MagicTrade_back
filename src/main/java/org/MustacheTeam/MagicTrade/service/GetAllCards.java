package org.MustacheTeam.MagicTrade.service;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.repository.JpaCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCards {

    private final JpaCardRepository jpaCardRepository;

    public GetAllCards(JpaCardRepository jpaCardRepository){
       this.jpaCardRepository =jpaCardRepository;
    }

    public List<Card> handle(){
     return jpaCardRepository.getAllCards();
 }
}
