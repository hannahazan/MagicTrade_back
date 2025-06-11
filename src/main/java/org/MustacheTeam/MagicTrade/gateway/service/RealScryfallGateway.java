package org.MustacheTeam.MagicTrade.gateway.service;

import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.model.*;
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


    public List<ScryfallCard> getScryfallCards() {
        List<ScryfallCard> scryfallCardList = new ArrayList<>();
        String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";

        ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);

        Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

        for (int j=1;j<=5;j++){
            String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
            ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);
            scryfallCardList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));
        }
        return scryfallCardList;
    }

    @Override
    public List<ScryfallSet> getScryfallSets() {
        List<ScryfallSet> scryfallSetList = new ArrayList<>();
        String url = "https://api.scryfall.com/sets";

        ResponseEntity<ScryfallMetadataSet> responseEntity = restTemplateApi.getForEntity(url, ScryfallMetadataSet.class);
        scryfallSetList.addAll(Objects.requireNonNull((Objects.requireNonNull(responseEntity.getBody()).data().stream().toList())));

        return scryfallSetList;
    }

    @Override
    public ArrayList<String> getScryfallCatalog(String catalogElement) {
        ArrayList<String> scryfallElementList = new ArrayList<>();
        String url = String.format("https://api.scryfall.com/catalog/%s", catalogElement);

        ResponseEntity<Catalog> responseEntity = restTemplateApi.getForEntity(url, Catalog.class);
        scryfallElementList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));

        return scryfallElementList;
    }
}
