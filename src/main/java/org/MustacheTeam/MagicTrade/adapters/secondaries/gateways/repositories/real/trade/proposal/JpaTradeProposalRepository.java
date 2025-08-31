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
    }

    public TradeProposalList getAllTradeProposalByTradeId(Long tradeId){
        List<TradeProposalEntity> tradeProposalEntities = repository.findAllWithItemsByTradeId(tradeId);

        List<TradeProposal> proposals = tradeProposalEntities.stream()
                .map(t -> new TradeProposal(
                        t.getId(),
                        t.getTrade().getId(),
                        t.getProposer().getId(),
                        t.getStatus().name(),
                        t.getCreatedAt(),
                        t.getMessage(),
                        t.getTradeItemProposalList().stream()
                                .map(i -> new TradeItemProposal(
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
                                ))
                                .toList()
                ))
                .toList();

        return new TradeProposalList(proposals);
    }

}
