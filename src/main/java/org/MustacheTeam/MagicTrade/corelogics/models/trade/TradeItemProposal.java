package org.MustacheTeam.MagicTrade.corelogics.models.trade;

<<<<<<< HEAD:src/main/java/org/MustacheTeam/MagicTrade/corelogics/models/TradeItemProposal.java
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
=======
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
>>>>>>> d0b5cd36875cfa5a70a0a2f7432909aef6e26fe2:src/main/java/org/MustacheTeam/MagicTrade/corelogics/models/trade/TradeItemProposal.java
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
