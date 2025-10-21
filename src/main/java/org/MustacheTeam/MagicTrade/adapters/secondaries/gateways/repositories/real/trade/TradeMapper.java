package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TradeMapper {
    private final SpringDataCollectionRepository collectionRepository;
    private final SpringDataUserRepository userRepository;

    public TradeMapper(SpringDataCollectionRepository collectionRepository, SpringDataUserRepository userRepository){
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
    }

    public Trade tradeEntityToTrade(TradeEntity tradeEntity){
        List<TradeProposal> proposals = new ArrayList<>();
        tradeEntity.getTradeProposalList().forEach(p -> {
            List<TradeItemProposal> items = new ArrayList<>();
            p.getTradeItemProposalList().forEach(i ->{
                items.add(new TradeItemProposal(
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
                ));
            });
            proposals.add(new TradeProposal(
                    p.getId(),
                    p.getTrade().getId(),
                    p.getProposer().getId(),
                    p.getStatus().name(),
                    p.getCreatedAt(),
                    p.getMessage(),
                    items
            ));
        });
        return new Trade(
                tradeEntity.getId(),
                tradeEntity.getInitiator().getId(),
                tradeEntity.getPartner().getId(),
                proposals,
                tradeEntity.getCreationDate(),
                tradeEntity.getClotureDate(),
                tradeEntity.getStatus().toString()
        );
    }

    public TradeEntity tradeToTradeEntity(Trade trade, UserEntity initiator, UserEntity partner, Long id){
        List<TradeProposalEntity> proposalEntityList = new ArrayList<>();
        TradeEntity tradeEntity = new TradeEntity(
                initiator,
                partner,
                LocalDateTime.now(),
                trade.clotureDate(),
                TradeStatus.OPEN
        );
        trade.proposals().forEach( p ->{
            List<TradeProposalItemEntity> items = new ArrayList<>();
            TradeProposalEntity proposal;
            proposalEntityList.add(
                    proposal =  new TradeProposalEntity(
                            tradeEntity,
                            initiator,
                            p.mapProposalStatus("PENDING"),
                            LocalDateTime.now(),
                            p.message()
                    )
            );
            p.tradeItemProposals().forEach( i->{
                CollectionEntity collection = findCollection(i.userCard().id());
                items.add(
                        new TradeProposalItemEntity(
                                proposal,
                                collection,
                                i.getSide(collection.getUserId().getId(),id)
                        )
                );
            });
            proposal.setTradeItemProposalList(items);
        });
        tradeEntity.setTradeProposalList(proposalEntityList);
        return tradeEntity;
    }

    public CollectionEntity findCollection( Long id){
        return collectionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: "));
    }

    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
}
