package org.MustacheTeam.MagicTrade.repository.card;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.Card;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface CardRepository {

    void save(List<ScryfallCard> cardToSave);

    List<Card> getAllCards();

    Card getCardById(String id);

    List<Card> getAllCardsWithFilters(String name, String setId, List<String> colors, List<Integer> cmc, String text);
}
