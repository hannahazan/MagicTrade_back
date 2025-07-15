package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.*;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ScryfallApiException;
import org.MustacheTeam.MagicTrade.corelogics.gateways.api.ScryfallGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RealScryfallGateway implements ScryfallGateway {

    private final RestTemplate restTemplateApi;

    public RealScryfallGateway(RestTemplate restTemplateApi){
        this.restTemplateApi = restTemplateApi;
    }

    @Override
    public List<ScryfallCard> getScryfallCards() {
        List<ScryfallCard> scryfallCardList = new ArrayList<>();

        try {
            String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";

            ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);

            Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

            for (int j=11;j<=15;j++){
                String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
                ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);
                scryfallCardList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));
            }

            return scryfallCardList;

        } catch(Exception ex) {
            throw new ScryfallApiException("Failed to correctly fetch cards from Scryfall : " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<ScryfallSet> getScryfallSets() {
        List<ScryfallSet> scryfallSetList = new ArrayList<>();
        try {
            String url = "https://api.scryfall.com/sets";

            ResponseEntity<ScryfallMetadataSet> responseEntity = restTemplateApi.getForEntity(url, ScryfallMetadataSet.class);
            scryfallSetList.addAll(Objects.requireNonNull((Objects.requireNonNull(responseEntity.getBody()).data().stream().toList())));

            return scryfallSetList;
        } catch(Exception ex) {
            throw new ScryfallApiException("Failed to correctly fetch sets from Scryfall: " + ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<String> getScryfallCatalog(String catalogElement) {
        try {
            ArrayList<String> scryfallElementList = new ArrayList<>();
            String url = String.format("https://api.scryfall.com/catalog/%s", catalogElement);

            ResponseEntity<Catalog> responseEntity = restTemplateApi.getForEntity(url, Catalog.class);
            scryfallElementList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));
            return scryfallElementList;
        } catch(Exception ex) {
            throw new ScryfallApiException("Failed to correctly fetch catalog data for '" + catalogElement + "' from Scryfall: " + ex.getMessage(), ex);
        }
    }
}
