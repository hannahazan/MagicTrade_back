package org.MustacheTeam.MagicTrade.gateway.interfacerest;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCardFinal;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCardList;

import java.util.ArrayList;
import java.util.List;

public interface ScryfallGateway {

   // ArrayList<Object> getScryfallCards();
    List<ScryfallCardFinal> getScryfallCards();
}
