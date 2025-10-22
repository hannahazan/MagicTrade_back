package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.SpringDataCollectionRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.SpringDataTradeRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeMapper;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.*;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.MapperTradeStatus;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.TradeRules;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class JpaTradeProposalRepository extends TradeRules implements TradeProposalRepository {

    private final SpringDataTradeProposalRepository repository;
    private final SpringDataTradeRepository tradeRepository;
    private final TradeProposalMapper tradeProposalMapper;
    private final TradeMapper tradeMapper;

    public JpaTradeProposalRepository(SpringDataTradeProposalRepository repository,
                                      SpringDataTradeRepository tradeRepository,
                                      TradeProposalMapper tradeProposalMapper,
                                      TradeMapper tradeMapper){
        this.repository = repository;
        this.tradeRepository = tradeRepository;
        this.tradeProposalMapper = tradeProposalMapper;
        this.tradeMapper = tradeMapper;
    }

    @Transactional
    @Override
    public void save(TradeProposal proposal, Long id){

        TradeEntity trade = tradeProposalMapper.getOneTrade(proposal.tradeId());
        List<TradeProposalEntity> proposalsEntities = repository.findAllByTradeId(proposal.tradeId());
        List<TradeProposal> proposals = proposalsEntities.stream().map(tradeProposalMapper::tradeProposalEntityToTradeProposal).toList();
        boolean isAllRejected = isAllProposingRejectedOrCancelled(proposals);
        boolean isTradeOpen = isTradeOpen(tradeMapper.tradeEntityToTrade(trade));

        if(isAllRejected && isTradeOpen){
            repository.save(tradeProposalMapper.tradePropopsalToTradeProposalEntity(proposal, trade, tradeProposalMapper.getOneUser(id), id));
        }else{
            if(!isTradeOpen){
                throw new IllegalStateException("This trade is closed, cancelled, rejected or already accepted");
            }
            throw new IllegalStateException("A proposal has already been accepted or is in pending");
        }
    }


    public TradeProposalList getAllTradeProposalByTradeId(Long tradeId){
        List<TradeProposalEntity> proposals = repository.findAllByTradeId(tradeId);
        List<TradeProposal> proposalsFinal = proposals.stream().map(tradeProposalMapper::tradeProposalEntityToTradeProposal
        ).toList();
        return new TradeProposalList(proposalsFinal);
    }

    @Override
    public void updateTradeProposalStatus(ProposalUpdate proposal, Long actualProposerId){
            TradeProposalEntity tradeProposalEntity = repository.findById(proposal.proposalId()).orElseThrow(()-> new IllegalArgumentException("This proposal does not exist"));
            TradeEntity tradeEntity = tradeProposalMapper.getOneTrade(tradeProposalEntity.getTrade().getId());

            Trade trade = tradeMapper.tradeEntityToTrade(tradeEntity);
            TradeProposal tradeProposal = tradeProposalMapper.tradeProposalEntityToTradeProposal(tradeProposalEntity);

            if(isAParticipantOfTheTrade(trade, actualProposerId)){
                if(isTradeOpen(trade)){
                    if(isProposalPending(tradeProposal)){
                        if(isNotTheProposer(actualProposerId,tradeProposal)){
                            if(proposal.proposalStatus().equalsIgnoreCase("ACCEPTED")){
                                tradeProposalEntity.setStatus(proposal.mapProposalStatus(proposal.proposalStatus().toUpperCase()));
                                tradeEntity.setStatus(MapperTradeStatus.mapTradeStatus("ACCEPTED"));
                                repository.save(tradeProposalEntity);
                                tradeRepository.save(tradeEntity);
                            }

                            else if(proposal.proposalStatus().equalsIgnoreCase("REJECTED") && proposal.tradeStatus().equalsIgnoreCase("REJECTED")){
                                tradeProposalEntity.setStatus(proposal.mapProposalStatus(proposal.proposalStatus().toUpperCase()));
                                tradeEntity.setStatus(MapperTradeStatus.mapTradeStatus(proposal.tradeStatus().toUpperCase()));
                                repository.save(tradeProposalEntity);
                                tradeRepository.save(tradeEntity);
                            }

                            else if(proposal.proposalStatus().equalsIgnoreCase("REJECTED") && proposal.tradeStatus().equalsIgnoreCase("OPEN")){
                                tradeProposalEntity.setStatus(proposal.mapProposalStatus(proposal.proposalStatus().toUpperCase()));
                                repository.save(tradeProposalEntity);
                            }
                            else{
                                throw new RuntimeException("Wrong status");
                            }
                        }else{
                            if (proposal.proposalStatus().equalsIgnoreCase("CANCELLED") && proposal.tradeStatus().equalsIgnoreCase("REJECTED")){
                                tradeProposalEntity.setStatus(proposal.mapProposalStatus(proposal.proposalStatus().toUpperCase()));
                                tradeEntity.setStatus(MapperTradeStatus.mapTradeStatus(proposal.tradeStatus().toUpperCase()));
                                repository.save(tradeProposalEntity);
                                tradeRepository.save(tradeEntity);
                            }
                            else if (proposal.proposalStatus().equalsIgnoreCase("CANCELLED") && proposal.tradeStatus().equalsIgnoreCase("OPEN")){
                                tradeProposalEntity.setStatus(proposal.mapProposalStatus(proposal.proposalStatus()));
                                repository.save(tradeProposalEntity);
                            }
                            else{
                                throw new RuntimeException("Wrong status");
                            }
                        }
                    }else{
                        throw new RuntimeException("this proposal is not in pending anymore");
                    }
                }else throw new IllegalStateException("This trade is no longer open");

            }else throw new RuntimeException("You have no right to update this proposal");

    }

}
