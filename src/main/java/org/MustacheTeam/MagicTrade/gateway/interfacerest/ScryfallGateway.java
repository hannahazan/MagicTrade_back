package org.MustacheTeam.MagicTrade.gateway.interfacerest;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallOnlyPaperCard;

import java.util.List;

public interface ScryfallGateway {

   // ArrayList<Object> getScryfallCards();
    List<ScryfallOnlyPaperCard> getScryfallCards();
}
