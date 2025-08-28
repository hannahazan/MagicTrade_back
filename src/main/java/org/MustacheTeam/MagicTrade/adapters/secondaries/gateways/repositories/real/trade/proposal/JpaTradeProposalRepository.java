package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import jakarta.transaction.Transactional;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.SpringDataTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.SpringDataProposalItemRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;

import java.time.LocalDateTime;
import java.util.*;

public class JpaTradeProposalRepository implements TradeProposalRepository {

    private final SpringDataTradeProposalRepository repository;
    private final SpringDataProposalItemRepository itemRepository;
    private final SpringDataTradeRepository tradeRepository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCollectionRepository collectionRepository;

    public JpaTradeProposalRepository(SpringDataProposalItemRepository itemRepository,
                                      SpringDataTradeProposalRepository repository,
                                      SpringDataTradeRepository tradeRepository,
                                      SpringDataUserRepository userRepository,
                                      SpringDataCollectionRepository collectionRepository){
        this.itemRepository = itemRepository;
        this.repository = repository;
        this.tradeRepository = tradeRepository;
        this.userRepository = userRepository;
        this.collectionRepository = collectionRepository;
    }

    @Transactional
    @Override
    public void save(TradeProposal proposal, Long id){
        List<TradeProposalItemEntity> items = new ArrayList<>();

        TradeEntity trade = tradeRepository.findById(proposal.tradeId()).orElseThrow(() -> new IllegalArgumentException("Trade not found with id: " + proposal.tradeId())) ;

        UserEntity proposer = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id:"));

        TradeProposalEntity tradeProposal = new TradeProposalEntity(
                trade,
                proposer,
                mapProposalStatus(proposal.status()),
                LocalDateTime.now(),
                proposal.message()
        );

        proposal.collectionCards().forEach( c ->{
            CollectionEntity collection = collectionRepository.findById(c).orElseThrow(() -> new IllegalArgumentException("User not found with id: "));
            items.add(
                    new TradeProposalItemEntity(
                            tradeProposal,
                            collection,
                            Objects.equals(collection.getUserId().getId(), id) ? ItemSide.OFFER:ItemSide.REQUEST
                    )
            );
        } );

        tradeProposal.setTradeItemProposalList(items);

        repository.save(tradeProposal);
    }

    public ProposalStatus mapProposalStatus(String status){
        if(status.equalsIgnoreCase("PENDING")){
            return ProposalStatus.PENDING;
        }
        else if(status.equalsIgnoreCase("ACCEPTED")){
            return ProposalStatus.ACCEPTED;
        }
        else if(status.equalsIgnoreCase("REJECTED")){
            return ProposalStatus.REJECTED;
        }
        return null;
    }
}
