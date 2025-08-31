package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeList;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTradeRepository implements TradeRepository {

    private final SpringDataTradeRepository repository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCollectionRepository collectionRepository;

    public JpaTradeRepository(SpringDataTradeRepository repository, SpringDataUserRepository springDataUserRepository,SpringDataCollectionRepository collectionRepository){
        this.repository = repository;
        this.userRepository = springDataUserRepository;
        this.collectionRepository = collectionRepository;
    }

    public void save(Trade trade, Long id){
        List<TradeProposalEntity> proposalEntityList = new ArrayList<>();
        TradeEntity tradeEntity = new TradeEntity(
                findUser(id),
                findUser(trade.partnerId()),
                LocalDateTime.now(),
                trade.clotureDate(),
                TradeStatus.OPEN
        );
        trade.proposals().forEach( p ->{
            List<TradeProposalItemEntity> items = new ArrayList<>();
            TradeProposalEntity proposal;
            UserEntity proposer = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id:"));
            proposalEntityList.add(
                   proposal =  new TradeProposalEntity(
                            tradeEntity,
                            proposer,
                            p.mapProposalStatus(p.status()),
                            LocalDateTime.now(),
                            p.message()
                    )
            );
            p.tradeItemProposals().forEach( i->{
                CollectionEntity collection = collectionRepository.findById(i.userCard().id()).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: "));
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
        repository.save(tradeEntity);
    }

    public TradeList findAllTradesByUserId(Long id){
        List<TradeEntity> tradeEntities = repository.findAllByInitiator_Id(id);
        List<Trade> trades = new ArrayList<>();
        tradeEntities.forEach( t -> trades.add(
                new Trade(
                        t.getId(),
                        t.getInitiator().getId(),
                        t.getPartner().getId(),
                        null,
                        t.getCreationDate(),
                        t.getClotureDate(),
                        t.getStatus().toString()
                )
        ));
        return new TradeList(trades);
    }

    public UserEntity findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

}
