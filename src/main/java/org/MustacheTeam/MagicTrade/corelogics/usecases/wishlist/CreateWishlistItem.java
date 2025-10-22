package org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistItem;

public class CreateWishlistItem {
    private final WishlistRepository repository;

    public CreateWishlistItem(WishlistRepository repository) {
        this.repository = repository;
    }

    public void handle(long userId, String cardId) {
        WishlistItem wishlistItem = new WishlistItem(userId, cardId);
        repository.save(wishlistItem);
    }
}
