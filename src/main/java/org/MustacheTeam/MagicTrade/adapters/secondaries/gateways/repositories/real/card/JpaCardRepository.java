package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Card;
import org.MustacheTeam.MagicTrade.corelogics.models.CardList;

import java.util.ArrayList;
import java.util.List;

public class JpaCardRepository implements CardRepository {

    private final SpringDataCardRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    public JpaCardRepository(final SpringDataCardRepository springDataCardRepository){
        this.repository = springDataCardRepository;
    }

    @Override
    public void save(List<ScryfallCard> cardToSave){
        List<CardEntity> cards = new ArrayList<>();
        cardToSave.forEach(card->{
            boolean isPaper = false;
            for(int i=0;i<card.games().size();i++){
                if (card.games().get(i).equals("paper")) {
                    isPaper = true;
                    break;
                }
            }
            final CardEntity entityCard = new CardEntity(card.id(), card.setId(), card.name(), card.manaCost(), card.cmc(), card.types(), card.text(), card.toughness(), card.power(), card.rarity(),
                    card.foil(), card.fullArt(), card.textLess(), card.purchase_uris() != null?card.purchase_uris().cardmarket():null, card.legalities().standard(), card.legalities().pioneer(), card.legalities().explorer()
                    , card.legalities().modern(), card.legalities().legacy(), card.legalities().pauper(), card.legalities().vintage(), card.legalities().commander(), card.legalities().brawl()
                    , card.legalities().commander(), card.legalities().duel(), card.legalities().oldschool(), card.image_uris() != null ? card.image_uris().normal() : null, card.image_uris() != null ? card.image_uris().art_crop() : null,
                    card.card_faces() != null
            );
            if(isPaper){
                cards.add(entityCard);
            }
        });
        repository.saveAll(cards);
    }

    @Override
    public CardList getAllCards(String id, String name, String setId, List<String> colors, List<String> cmc, String text, List<String> toughnesses, List<String> powers,
                                List<String> rarities, List<String> types, String foil, String fullArt, String textLess, String standard, String pioneer, String explorer, String modern,
                                String legacy, String pauper, String vintage, String commander, String brawl, String pauperCommander, String duel, String oldSchool
                                 ){

        List<Card> cards = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CardEntity> query = cb.createQuery(CardEntity.class);
        Root<CardEntity> root = query.from(CardEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if(!id.isEmpty()){
            predicates.add(cb.equal(cb.lower(root.get("id")),id.toLowerCase()));
        }

        if(!name.isEmpty()){
            predicates.add(cb.equal(cb.lower(root.get("name")),name.toLowerCase()));
        }

        if(!setId.isEmpty()){
            predicates.add(cb.equal(root.get("setId"),setId));
        }

        if(!colors.isEmpty()){
            List<Predicate> likePredicates = new ArrayList<>();
            colors.forEach(c->{
                Predicate like = cb.like(cb.lower(root.get("manaCost")),"%" + c.toLowerCase() + "%");
                likePredicates.add(like);
            });
            Predicate orLike = cb.or(likePredicates.toArray(new Predicate[0]));
            predicates.add(orLike);
        }

        if(!cmc.isEmpty()){
            List<Predicate> equalPredicates = new ArrayList<>();
            cmc.forEach(c->{
                Predicate equal = cb.equal(cb.toString(root.get("cmc")),c);
                equalPredicates.add(equal);
            });
            Predicate orEqual = cb.or(equalPredicates.toArray(new Predicate[0]));
            predicates.add(orEqual);
        }

        if(!text.isEmpty()){
            predicates.add(cb.like(cb.lower(root.get("text")),"%"+text.toLowerCase()+"%"));
        }

        if(!toughnesses.isEmpty()){
            List<Predicate> equalPredicates = new ArrayList<>();
            toughnesses.forEach(t->{
                Predicate equal = cb.equal(root.get("toughness"),t);
                equalPredicates.add(equal);
            });
            Predicate orEqual = cb.or(equalPredicates.toArray(new Predicate[0]));
            predicates.add(orEqual);
        }

        if(!powers.isEmpty()){
            List<Predicate> equalPredicates = new ArrayList<>();
            powers.forEach(p->{
                Predicate equal = cb.equal(root.get("power"),p);
                equalPredicates.add(equal);
            });
            Predicate orEqual = cb.or(equalPredicates.toArray(new Predicate[0]));
            predicates.add(orEqual);
        }

        if(!rarities.isEmpty()){
            List<Predicate> equalPredicates = new ArrayList<>();
            rarities.forEach(r->{
                Predicate equal = cb.equal(cb.lower(root.get("rarity")),r.toLowerCase());
                equalPredicates.add(equal);
            });
            Predicate orEqual = cb.or(equalPredicates.toArray(new Predicate[0]));
            predicates.add(orEqual);
        }

        if(!types.isEmpty()){
            List<Predicate> likePredicates = new ArrayList<>();
            types.forEach(t->{
                Predicate like = cb.like(cb.lower(root.get("types")),"%" + t.toLowerCase() + "%");
                likePredicates.add(like);
            });
            Predicate orLike = cb.or(likePredicates.toArray(new Predicate[0]));
            predicates.add(orLike);
        }

        if(!foil.isEmpty()){
            predicates.add(cb.equal(cb.lower(cb.toString(root.get("foil"))), foil.toLowerCase()));
        }

        if(!fullArt.isEmpty()){
            predicates.add(cb.equal(cb.lower(cb.toString(root.get("fullArt"))), fullArt.toLowerCase()));
        }

        if(!textLess.isEmpty()){
            predicates.add(cb.equal(cb.lower(cb.toString(root.get("textLess"))), textLess.toLowerCase()));
        }

        if(!standard.isEmpty()){
            predicates.add(cb.equal(cb.lower(cb.toString(root.get("standard"))), standard.toLowerCase()));
        }

        if(!pioneer.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("pioneer")), pioneer));
        }

        if(!explorer.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("explorer")), explorer));
        }

        if(!modern.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("modern")), modern));
        }

        if(!legacy.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("legacy")), legacy));
        }

        if(!pauper.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("pauper")), pauper));
        }

        if(!vintage.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("vintage")), vintage));
        }

        if(!commander.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("commander")), commander));
        }

        if(!brawl.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("brawl")), brawl));
        }

        if(!pauperCommander.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("pauperCommander")), pauperCommander));
        }

        if(!duel.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("duel")), duel));
        }

        if(!oldSchool.isEmpty()){
            predicates.add(cb.equal(cb.toString(root.get("oldSchool")), oldSchool));
        }

        if(!predicates.isEmpty()){
            query.where((cb.and(predicates.toArray(new Predicate[0]))));
        }

        entityManager.createQuery(query).getResultList().forEach(c->cards.add(new Card(c.getId(),c.getSetId(),
                c.getName(),c.getManaCost(),c.getCmc(),c.getTypes(),c.getText(),c.getToughness(),c.getPower(),c.getRarity(),c.getFoil(),c.getFullArt(),c.getTextLess(),
                c.getCardMarketPrice(),c.getStandard(),c.getPioneer(),c.getExplorer(),c.getModern(),c.getLegacy(),c.getPauper(),c.getVintage(),c.getCommander(),c.getBrawl(),c.getPauperCommander(),
                c.getDuel(),c.getOldSchool(),c.getImageSizeNormal(),c.getImageSizeArtCrop(), c.getIsDoubleCard())));

        return new CardList(cards);
    }
}
