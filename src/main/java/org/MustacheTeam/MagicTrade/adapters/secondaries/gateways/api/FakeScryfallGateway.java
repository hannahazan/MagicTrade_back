package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;

import java.util.ArrayList;
import java.util.List;

public class FakeScryfallGateway implements ScryfallGateway {
    private final List<ScryfallCard> scryfallCards = new ArrayList<>();
    private final List<ScryfallSet> scryfallSets = new ArrayList<>();
    private final ArrayList<String> filters = new ArrayList<>();

    @Override
    public List<ScryfallCard> getScryfallCards(){
        return scryfallCards;
    }

    @Override
    public List<ScryfallSet> getScryfallSets(){
        return scryfallSets;
    }

    @Override
    public ArrayList<String> getScryfallCatalog(String catalogElement){
        return filters;
    }

    public void feedScryfallCards(List<ScryfallCard> cards){
        scryfallCards.addAll(cards);
    }

    public void feedScryfallSets(List<ScryfallSet> sets){
        scryfallSets.addAll(sets);
    }

    public void feedFilters(ArrayList<String> scryFilters){
        filters.addAll(scryFilters);
    }

}
