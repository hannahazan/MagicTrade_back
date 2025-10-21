package org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.WishlistItem;

public class GetWishlistByUser {
    private final WishlistRepository repository;

    public GetWishlistByUser(WishlistRepository repository) {
        this.repository = repository;
    }

    public void handle() {
        // TODO
    }
}
