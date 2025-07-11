package org.MustacheTeam.MagicTrade.service.card;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.repository.card.CardRepository;
import org.MustacheTeam.MagicTrade.repository.card.JpaCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCards {

    private final CardRepository cardRepository;

    public GetAllCards(CardRepository cardRepository){
       this.cardRepository = cardRepository;
    }

    public List<Card> handle(String name, String setId, List<String> colors, List<Integer> cmc, String text, List<String> toughnesses, List<String> powers,
                                List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard, String pioneer, String explorer, String modern,
                                String legacy, String pauper, String vintage, String commander, String brawl, String pauperCommander, String duel, String oldSchool)
                                {
        return cardRepository.getAllCards(name, setId, colors, cmc, text, toughnesses, powers, rarities, types, foil,
                fullArt, textLess, standard, pioneer, explorer, modern, legacy, pauper, vintage, commander, brawl, pauperCommander, duel, oldSchool);
    }
}
