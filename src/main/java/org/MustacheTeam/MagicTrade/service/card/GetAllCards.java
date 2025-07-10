package org.MustacheTeam.MagicTrade.service.card;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.repository.card.JpaCardRepository;
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
    public List<Card> handleAll(String name, String setId, List<String> colors, List<Integer> cmc, String text){
        return jpaCardRepository.getAllCardsWithFilters(name, setId, colors, cmc, text);
    }
}
