package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.SpringDataTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class JpaTradeProposalRepository implements TradeProposalRepository {

    private final SpringDataTradeProposalRepository repository;
    private final SpringDataTradeRepository tradeRepository;
    private final SpringDataUserRepository userRepository;
    private final SpringDataCollectionRepository collectionRepository;

    public JpaTradeProposalRepository(SpringDataTradeProposalRepository repository,
                                      SpringDataTradeRepository tradeRepository,
                                      SpringDataUserRepository userRepository,
                                      SpringDataCollectionRepository collectionRepository){
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

        List<TradeProposalEntity> proposals = repository.findAllByTradeId(proposal.tradeId());

        boolean isAllRejected = isAllProposingRejected(proposals);

        if(isAllRejected){
            TradeProposalEntity tradeProposal = new TradeProposalEntity(
                    trade,
                    proposer,
                    proposal.mapProposalStatus(proposal.status()),
                    LocalDateTime.now(),
                    proposal.message()
            );

            proposal.tradeItemProposals().forEach( c ->{
                CollectionEntity collection = collectionRepository.findById(c.userCard().id()).orElseThrow(() -> new IllegalArgumentException("Collection not found with id: "));
                items.add(
                        new TradeProposalItemEntity(
                                tradeProposal,
                                collection,
                                c.getSide(collection.getUserId().getId(),id)
                        )
                );
            } );

            tradeProposal.setTradeItemProposalList(items);

            repository.save(tradeProposal);
        }else{
            throw new IllegalStateException("A proposal has already be accepted or is in pending");
        }
    }

    public boolean isAllProposingRejected(List<TradeProposalEntity> proposals){
        AtomicBoolean isAllProposingRejected = new AtomicBoolean(true);
        proposals.forEach(p -> {
            if(Objects.equals(p.getStatus().name(), "PENDING") || Objects.equals(p.getStatus().name(), "ACCEPTED")){
                isAllProposingRejected.set(false);
            }
        });
        return isAllProposingRejected.get();
    }

    public TradeProposalList getAllTradeProposalByTradeId(Long tradeId){

        List<TradeProposalEntity> proposals = repository.findAllByTradeId(tradeId);

        List<TradeProposal> proposalsFinal = proposals.stream().map( p ->
                new TradeProposal(
                        p.getId(),
                        p.getTrade().getId(),
                        p.getProposer().getId(),
                        p.getStatus().name(),
                        p.getCreatedAt(),
                        p.getMessage(),
                        p.getTradeItemProposalList().stream().map( i->
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
                                ).toList())
        ).toList();

        return new TradeProposalList(proposalsFinal);
    }

}
