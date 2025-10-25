package org.MustacheTeam.MagicTrade.corelogics.models.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;

import java.util.Objects;

public record TradeItemToSave(
        Long collectionId
) {
    public ItemSide getSide(Long userId, Long currentUserId){
        if(Objects.equals(userId, currentUserId)){
            return ItemSide.OFFER;
        }
        return ItemSide.REQUEST;
    }
}
