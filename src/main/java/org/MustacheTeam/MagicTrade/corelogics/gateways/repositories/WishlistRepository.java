package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistCard;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistItem;

import java.util.List;

public interface WishlistRepository {
    void save(WishlistItem wishlistItem);
    List<WishlistCard> findByUserId(Long userId);
    boolean existsByUserIdAndCardId(Long userId, String cardId);
    void deleteByUserIdAndCardId(Long userId, String cardId);
}
