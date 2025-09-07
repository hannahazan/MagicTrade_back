package org.MustacheTeam.MagicTrade.corelogics.models;

import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;

import java.util.Objects;

public record TradeItemProposal(
        Long id,
        Long tradeProposalId,
        Collection userCard,
        String cardImage,
        String side
) {
    public ItemSide getSide(Long userId, Long currentUserId){
        if(Objects.equals(userId, currentUserId)){
            return ItemSide.OFFER;
        }
        return ItemSide.REQUEST;
    }
}
