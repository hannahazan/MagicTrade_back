package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.Utils;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeItemToSave;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.TradeRules;

public class TradeProposalItemMapper extends TradeRules {
    private final Utils utils;

    public TradeProposalItemMapper(Utils utils){
        this.utils = utils;
    }

    public TradeProposalItemEntity tradeProposalItemToTradeProposalItemEntity(TradeItemToSave item, Long initiatorId, Long partnerId, Long currentUserId,
                                                                                  TradeProposalEntity tradeProposal){
        CollectionEntity collectionEntity = utils.findCollection(item.collectionId());
        Collection collection = new Collection(collectionEntity.getId(),
                collectionEntity.getUserId().getId(),
                collectionEntity.getCardId().getId(),
                collectionEntity.getLang(),
                collectionEntity.getState().name());

        if(isCardCollectionFromParticipants(collection, initiatorId, partnerId)){
            return new TradeProposalItemEntity(
                    tradeProposal,
                    collectionEntity,
                    item.getSide(collectionEntity.getUserId().getId(),currentUserId)
            );
        }else{
            throw new RuntimeException(String.format("this card, id : %d, doesn't belong to a participant of this trade", item.collectionId()));
        }
    }

    public TradeItemProposal tradeProposalItemEntityToTradeItemProposal(TradeProposalItemEntity item){
        return  new TradeItemProposal(
                item.getId(),
                item.getProposal().getId(),
                new Collection(
                        item.getCollectionCard().getId(),
                        item.getCollectionCard().getUserId().getId(),
                        item.getCollectionCard().getCardId().getId(),
                        item.getCollectionCard().getLang(),
                        item.getCollectionCard().getState().name()
                ),
                item.getCollectionCard().getCardId().getImageSizeNormal(),
                item.getSide().name()
        );
    }
}
