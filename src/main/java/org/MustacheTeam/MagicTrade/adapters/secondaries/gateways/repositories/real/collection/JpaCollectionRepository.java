package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection;
import jakarta.transaction.Transactional;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionCard;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionDoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionItem;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.CardState;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JpaCollectionRepository implements CollectionRepository {

    private final SpringDataCollectionRepository repository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCardRepository cardRepository;

    public JpaCollectionRepository(SpringDataCollectionRepository repository,
                                   SpringDataUserRepository userRepository,
                                   SpringDataCardRepository cardRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void save(CollectionItem collectionItem) {
        UserEntity user = userRepository.findById(collectionItem.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + collectionItem.userId()));

        CardEntity card = cardRepository.findById(collectionItem.cardId())
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with id: " + collectionItem.cardId()));
        CardState cardState;
        try {
            cardState = CardState.valueOf(collectionItem.state().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("Invalid card state: " + collectionItem.state());
        }

        CollectionEntity entity = new CollectionEntity();
        entity.setUserId(user);
        entity.setCardId(card);
        entity.setLang(collectionItem.lang());
        entity.setState(cardState);

        repository.save(entity);
    }

     // Get all cards from user collection
    @Override
    public List<CollectionCard> findByUserId(Long userId) {
        List<CollectionEntity> entities = repository.findByUserId_Id(userId);
        List<CollectionCard> collections = new ArrayList<>();

        entities.forEach(entity -> collections.add(new CollectionCard(
                entity.getId(),
                entity.getUserId().getId(),
                entity.getCardId().getId(),
                entity.getLang(),
                entity.getState().name(),
                entity.getCardId().getImageSizeNormal(),
                entity.getCardId().getIsDoubleCard(),
                entity.getCardId().getDoubleCards().stream()
                        .map(doubleCard -> new CollectionDoubleCard(
                                doubleCard.getId(),
                                doubleCard.getCard().getId(),
                                doubleCard.getImageSizeNormal()
                        ))
                        .toList()
        )));

        return collections;
    }

    // Delete one card and the last one if sames cards
    @Override
    @Transactional
    public void deleteByIdAndUserId(Long collectionId, Long userId) {
        int deleted = repository.deleteByIdAndUserId_Id(collectionId, userId);
        if (deleted == 0) {
            throw new ResourceNotFoundException(
                    "Collection item not found for id=" + collectionId + " and userId=" + userId
            );
        }
    }
}