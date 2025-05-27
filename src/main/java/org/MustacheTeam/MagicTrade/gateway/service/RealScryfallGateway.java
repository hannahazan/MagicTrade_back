package org.MustacheTeam.MagicTrade.gateway.service;

import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCardFinal;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCardList;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallMetaData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class RealScryfallGateway implements ScryfallGateway {

    private final RestTemplate restTemplateApi;

    public RealScryfallGateway(RestTemplate restTemplateApi){
        this.restTemplateApi = restTemplateApi;
    }

    @Override
    public List<ScryfallCardFinal> getScryfallCards() {
        System.out.println("je suis dedans");
        List<ScryfallCard> scryfallCardList = new ArrayList<>();
        List<ScryfallCardFinal> realScryfallCardList = new ArrayList<>();
        HashMap< String , Integer > map = new HashMap <> ();
        String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";
        ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);
        Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

        for (int j=1;j<=10;j++){
            System.out.println(j);
            String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
            System.out.println(urlLoop);
            ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);
            String cardMarket ;
            scryfallCardList.addAll(Objects.requireNonNull(responseEntity.getBody().data().stream().toList()));
            scryfallCardList.forEach(card -> realScryfallCardList.add(new ScryfallCardFinal(card.id(),card.set_id(),card.name(),card.mana_cost(),
            card.cmc(),card.type_line(),card.oracle_text(),card.rarity(),card.foil(),card.full_art(),card.textless(),card.purchase_uris()!=null?card.purchase_uris().cardmarket() : "pas de value")));
        }
         return realScryfallCardList;
    }

}
