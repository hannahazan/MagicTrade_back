package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.SpringDataTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TradeProposalMapper {
    private final SpringDataTradeRepository tradeRepository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCollectionRepository collectionRepository;

    public TradeProposalMapper(SpringDataTradeRepository tradeRepository, SpringDataUserRepository userRepository, SpringDataCollectionRepository collectionRepository){
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
        this.collectionRepository = collectionRepository;
    }


    public TradeProposalEntity tradePropopsalToTradeProposalEntity(TradeProposal proposal, TradeEntity trade, UserEntity proposer, Long currentUserId){
        List<TradeProposalItemEntity> items = new ArrayList<>();
        TradeProposalEntity tradeProposal = new TradeProposalEntity(
                trade,
                proposer,
                proposal.mapProposalStatus("PENDING"),
                LocalDateTime.now(),
                proposal.message()
        );

        proposal.tradeItemProposals().forEach( c ->{
            CollectionEntity collection = findCollection(c.userCard().id());
            items.add(
                    new TradeProposalItemEntity(
                            tradeProposal,
                            collection,
                            c.getSide(collection.getUserId().getId(),currentUserId)
                    )
            );
        } );
        tradeProposal.setTradeItemProposalList(items);
        return tradeProposal;
    }

    public TradeProposal tradeProposalEntityToTradeProposal(TradeProposalEntity tradeProposalEntity){
        return new TradeProposal(
                tradeProposalEntity.getId(),
                tradeProposalEntity.getTrade().getId(),
                tradeProposalEntity.getProposer().getId(),
                tradeProposalEntity.getStatus().name(),
                tradeProposalEntity.getCreatedAt(),
                tradeProposalEntity.getMessage(),
                tradeProposalEntity.getTradeItemProposalList().stream().map(i->
                        new TradeItemProposal(
                                i.getId(),
                                i.getProposal().getId(),
                                new Collection(
                                        i.getCollectionCard().getId(),
                                        i.getCollectionCard().getUserId().getId(),
                                        i.getCollectionCard().getCardId().getId(),
                                        i.getCollectionCard().getLang(),
                                        i.getCollectionCard().getState()
                                ),
                                i.getCollectionCard().getCardId().getImageSizeNormal(),
                                i.getSide().name()
                        )
                ).toList());
    }

    public TradeEntity getOneTrade(Long id){
        return tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Trade not found with id: " + id)) ;
    }

    public UserEntity getOneUser(Long id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id:"));
    }

    public CollectionEntity findCollection( Long id){
        return collectionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: "));
    }
}
