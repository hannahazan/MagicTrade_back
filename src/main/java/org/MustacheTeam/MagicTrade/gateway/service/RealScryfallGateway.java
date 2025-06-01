package org.MustacheTeam.MagicTrade.gateway.service;

import org.MustacheTeam.MagicTrade.gateway.interfacerest.ScryfallGateway;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallOnlyPaperCard;
import org.MustacheTeam.MagicTrade.gateway.model.doubleCard;
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
    public List<ScryfallOnlyPaperCard> getScryfallCards() {
        System.out.println("je suis dedans");
        List<ScryfallCard> scryfallCardList = new ArrayList<>();
        List<ScryfallOnlyPaperCard> realScryfallCardList = new ArrayList<>();
        List<doubleCard> doubleCard = new ArrayList<>();
        String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";

        ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);

        Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

        for (int j=20;j<=30;j++){
            System.out.println(j);
            String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
            System.out.println(urlLoop);
            ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);

            scryfallCardList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));

            scryfallCardList.forEach(card -> {
                boolean isPaper = false;
                for(int i=0;i<card.games().size();i++){
                    if (card.games().get(i).equals("paper")) {
                        isPaper = true;
                        break;
                    }
                }
                final ScryfallOnlyPaperCard e = new ScryfallOnlyPaperCard(card.id(), card.setId(), card.name(), card.manaCost(), card.cmc(), card.types(), card.text(), card.toughness(), card.power(), card.rarity(),
                        card.foil(), card.fullArt(), card.textLess(), card.purchase_uris() != null?card.purchase_uris().cardmarket():null, card.legalities().standard(), card.legalities().pioneer(), card.legalities().explorer()
                        , card.legalities().modern(), card.legalities().legacy(), card.legalities().pauper(), card.legalities().vintage(), card.legalities().commander(), card.legalities().brawl()
                        , card.legalities().commander(), card.legalities().duel(), card.legalities().oldschool(), card.image_uris() != null ? card.image_uris().normal() : null, card.image_uris() != null ? card.image_uris().art_crop() : null
                );
                if(isPaper && Objects.isNull(card.card_faces())){
                    realScryfallCardList.add(e);
                }
                else if(isPaper){
                    card.card_faces().stream().map(c->doubleCard.add(new doubleCard(
                            card.id(),c.name(),c.mana_cost(),c.type_line(),c.oracle_text(),c.power(),c.toughness(),c.image_uris()
                    )));
                    realScryfallCardList.add(e);
                }
            });
        }
         return realScryfallCardList;
    }

    public List<ScryfallCard> getScryfallCardsTest() {
        System.out.println("je suis dedans");
        List<ScryfallCard> scryfallCardList = new ArrayList<>();
        List<ScryfallOnlyPaperCard> realScryfallCardList = new ArrayList<>();
        HashMap< String , Integer > map = new HashMap <> ();
        String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";

        ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);

        Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

        for (int j=1;j<=5;j++){
            System.out.println(j);
            String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
            System.out.println(urlLoop);
            ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);

            scryfallCardList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));
        }
        return scryfallCardList;
    }

    public List<doubleCard> getScryfallDoubleCards() {
        System.out.println("je suis dedans");
        List<ScryfallCard> scryfallCardList = new ArrayList<>();
        List<ScryfallOnlyPaperCard> onlyPaperCards = new ArrayList<>();
        List<doubleCard> doubleCard = new ArrayList<>();
        HashMap< String , Integer > map = new HashMap <> ();
        String url = "https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=1&q=!&unique=prints";

        ResponseEntity<ScryfallMetaData> responseEntityBefore = restTemplateApi.getForEntity(url,ScryfallMetaData.class);

        Math.ceil((double) Objects.requireNonNull(responseEntityBefore.getBody()).total_cards() / 175);

        for (int j=1;j<=5;j++){
            System.out.println(j);
            String urlLoop = String.format("https://api.scryfall.com/cards/search?format=json&include_extras=false&include_multilingual=false&include_variations=false&order=name&page=%d&q=!&unique=prints", j);
            System.out.println(urlLoop);
            ResponseEntity<ScryfallMetaData> responseEntity = restTemplateApi.getForEntity(urlLoop,ScryfallMetaData.class);

            scryfallCardList.addAll(Objects.requireNonNull(Objects.requireNonNull(responseEntity.getBody()).data().stream().toList()));

            scryfallCardList.forEach(card -> {
                boolean isPaper = false;
                for(int i=0;i<card.games().size();i++){
                    if (card.games().get(i).equals("paper")) {
                        isPaper = true;
                        break;
                    }
                }
                final ScryfallOnlyPaperCard e = new ScryfallOnlyPaperCard(card.id(), card.setId(), card.name(), card.manaCost(), card.cmc(), card.types(), card.text(), card.toughness(), card.power(), card.rarity(),
                        card.foil(), card.fullArt(), card.textLess(), card.purchase_uris() != null?card.purchase_uris().cardmarket():null, card.legalities().standard(), card.legalities().pioneer(), card.legalities().explorer()
                        , card.legalities().modern(), card.legalities().legacy(), card.legalities().pauper(), card.legalities().vintage(), card.legalities().commander(), card.legalities().brawl()
                        , card.legalities().commander(), card.legalities().duel(), card.legalities().oldschool(), card.image_uris() != null ? card.image_uris().normal() : null, card.image_uris() != null ? card.image_uris().art_crop() : null
                );
                if(isPaper && Objects.isNull(card.card_faces())){
                    onlyPaperCards.add(e);
                }
                else if(isPaper){
                    card.card_faces().stream().map(c->doubleCard.add(new doubleCard(
                            card.id(),c.name(),c.mana_cost(),c.type_line(),c.oracle_text(),c.power(),c.toughness(),c.image_uris()
                    ))).toList();
                    onlyPaperCards.add(e);
                }
            });
        }
        System.out.println(doubleCard.size());
        return doubleCard;
    }

}
