package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Wishlist;
import org.MustacheTeam.MagicTrade.corelogics.models.WishlistItem;

public interface WishlistRepository {
    void save(WishlistItem wishlistItem);
    Wishlist findByUserId(Long userId);
    boolean existsByUserIdAndCardId(Long userId, String cardId);
    void deleteByUserIdAndCardId(Long userId, String cardId);
}
