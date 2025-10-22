package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.wishlist;

import jakarta.transaction.Transactional;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceNotFoundException;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistCard;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistDoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistItem;

import java.util.ArrayList;
import java.util.List;

public class JpaWishlistRepository implements WishlistRepository {
    private final SpringDataWishlistRepository repository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCardRepository cardRepository;

    public JpaWishlistRepository(SpringDataWishlistRepository repository,
                          SpringDataUserRepository userRepository,
                          SpringDataCardRepository cardRepository
                          ) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void save(WishlistItem wishlistItem) {
        if (this.existsByUserIdAndCardId(wishlistItem.userId(), wishlistItem.cardId())) {
            return; // already in wishlist
        }

        UserEntity user = userRepository.findById(wishlistItem.userId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        CardEntity card = cardRepository.findById(wishlistItem.cardId())
            .orElseThrow(() -> new ResourceNotFoundException("Card id does not match any card"));

        WishlistEntity wishlistEntity = new WishlistEntity();
        wishlistEntity.setUser(user);
        wishlistEntity.setCard(card);

        this.repository.save(wishlistEntity);
    }

    @Override
    public List<WishlistCard> findByUserId(Long userId) {
        List<WishlistEntity> wishlistEntities = repository.findByUser_Id(userId);

        List<WishlistCard> wishlist = new ArrayList<>();

        wishlistEntities.forEach(entity -> wishlist.add(new WishlistCard(
            entity.getId(),
            entity.getUser().getId(),
            entity.getCard().getId(),
            entity.getCard().getImageSizeNormal(),
            entity.getCard().getIsDoubleCard(),
            entity.getCard().getDoubleCards().stream().map(doubleCard -> new WishlistDoubleCard(
                    doubleCard.getId(),
                    doubleCard.getCard().getId(),
                    doubleCard.getImageSizeNormal()
                )
            ).toList()
        )));

        return wishlist;
    }

    @Override
    public boolean existsByUserIdAndCardId(Long userId, String cardId) {
        List<WishlistEntity> wishlist = repository.findByUser_IdAndCard_Id(userId, cardId);
        return !wishlist.isEmpty();
    }

    @Override
    @Transactional
    public void deleteByUserIdAndCardId(Long userId, String cardId) {
        if (!this.existsByUserIdAndCardId(userId, cardId)) {
            throw new RuntimeException("card and user pair not found in wishlist");
        }
        this.repository.deleteByUser_IdAndCard_Id(userId, cardId);
    }
}
