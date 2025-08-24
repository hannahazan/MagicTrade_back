package org.MustacheTeam.MagicTrade.corelogics.gateways.api;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;

import java.util.ArrayList;
import java.util.List;

public interface ScryfallGateway {
    List<ScryfallCard> getScryfallCards();
    List<ScryfallSet> getScryfallSets();
    List<String> getScryfallCatalog(String catalogElement);
}
