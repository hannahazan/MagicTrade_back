package org.MustacheTeam.MagicTrade.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaCardRepository implements CardRepository {

    private final SpringDataCardRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public JpaCardRepository(final SpringDataCardRepository springDataCardRepository){
        this.repository = springDataCardRepository;
    }

    @Override
    public void save(List<ScryfallCard> cardToSave){
        List<Card> cards = new ArrayList<>();
        cardToSave.forEach(card->{
            boolean isPaper = false;
            for(int i=0;i<card.games().size();i++){
                if (card.games().get(i).equals("paper")) {
                    isPaper = true;
                    break;
                }
            }
            final Card entityCard = new Card(card.id(), card.setId(), card.name(), card.manaCost(), card.cmc(), card.types(), card.text(), card.toughness(), card.power(), card.rarity(),
                    card.foil(), card.fullArt(), card.textLess(), card.purchase_uris() != null?card.purchase_uris().cardmarket():null, card.legalities().standard(), card.legalities().pioneer(), card.legalities().explorer()
                    , card.legalities().modern(), card.legalities().legacy(), card.legalities().pauper(), card.legalities().vintage(), card.legalities().commander(), card.legalities().brawl()
                    , card.legalities().commander(), card.legalities().duel(), card.legalities().oldschool(), card.image_uris() != null ? card.image_uris().normal() : null, card.image_uris() != null ? card.image_uris().art_crop() : null
            );
            if(isPaper){
                cards.add(entityCard);
            }
        });
        repository.saveAll(cards);
    }

    @Override
    public List<Card> getAllCards(){
        return repository.findAll();
    }

    @Override
    public Card getCardById(String id){
        return repository.findCardById(id);
    }

    @Override
    public List<Card> getAllCardsWithFilters(String name, String setId, List<String> colors, List<Integer> cmc, String text){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Card> query = cb.createQuery(Card.class);
        Root<Card> root = query.from(Card.class);

        List<Predicate> predicates = new ArrayList<>();

        if(!name.isEmpty()){
            predicates.add(cb.equal(root.get("name"),name));
        }

        if(!setId.isEmpty()){
            predicates.add(cb.equal(root.get("setId"),setId));
        }

        if(!colors.isEmpty()){
            List<Predicate> likePredicates = new ArrayList<>();
            colors.forEach(c->{
                Predicate like = cb.like(root.get("manaCost"),"%" + c + "%");
                likePredicates.add(like);
            });
            Predicate orLike = cb.or(likePredicates.toArray(new Predicate[0]));
            predicates.add(orLike);
        }

        if(!cmc.isEmpty()){
            List<Predicate> equalPredicates = new ArrayList<>();
            cmc.forEach(c->{
                Predicate equal = cb.equal(root.get("cmc"),c);
                equalPredicates.add(equal);
            });
            Predicate orEqual = cb.or(equalPredicates.toArray(new Predicate[0]));
            predicates.add(orEqual);
        }

        if(!text.isEmpty()){
            predicates.add(cb.like(cb.lower(root.get("text")),"%"+text.toLowerCase()+"%"));
        }

        if(!predicates.isEmpty()){
            query.where((cb.and(predicates.toArray(new Predicate[0]))));
        }
        return entityManager.createQuery(query).getResultList();
    }
}
