package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.wishlist;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Wishlist;
import org.MustacheTeam.MagicTrade.corelogics.models.WishlistItem;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceNotFoundException;

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
    public Wishlist findByUserId(Long userId) {
        return null;
    }

    @Override
    public boolean existsByUserIdAndCardId(Long userId, String cardId) {
        List<WishlistEntity> wishlist = repository.findByUser_IdAndCard_Id(userId, cardId);
        return !wishlist.isEmpty();
    }

    @Override
    public void deleteByUserIdAndCardId(Long userId, String cardId) {

    }
}
