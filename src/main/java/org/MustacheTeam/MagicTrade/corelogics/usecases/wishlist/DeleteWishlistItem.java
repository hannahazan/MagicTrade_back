package org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;

public class DeleteWishlistItem {
    private final WishlistRepository wishlistRepository;

    public DeleteWishlistItem(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void handle() {
        // TODO
    }
}
