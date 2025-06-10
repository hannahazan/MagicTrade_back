package org.MustacheTeam.MagicTrade.gateway.interfacerest;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallSet;

import java.util.List;

public interface ScryfallGateway {
    List<ScryfallCard> getScryfallCards();
    List<ScryfallSet> getScryfallSets();
}
