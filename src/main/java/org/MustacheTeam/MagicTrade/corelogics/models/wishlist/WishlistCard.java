package org.MustacheTeam.MagicTrade.corelogics.models.wishlist;

import java.util.List;

public record WishlistCard(
        Long id,
        Long userId,
        String cardId,
        String imageSizeNormal,
        boolean isDoubleCard,
        List<WishlistDoubleCard> doubleCards
) {
}
