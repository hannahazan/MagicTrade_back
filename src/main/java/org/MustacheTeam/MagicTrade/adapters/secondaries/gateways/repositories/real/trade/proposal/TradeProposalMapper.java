package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemMapper;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TradeProposalMapper  {


    private final TradeProposalItemMapper tradeProposalItemMapper;

    public TradeProposalMapper(TradeProposalItemMapper tradeProposalItemMapper){
        this.tradeProposalItemMapper = tradeProposalItemMapper;
    }


    public TradeProposalEntity tradeProposalToTradeProposalEntity(TradeProposalToSave proposal, TradeEntity trade, UserEntity proposer, Long currentUserId){
        List<TradeProposalItemEntity> items = new ArrayList<>();
        TradeProposalEntity tradeProposal = new TradeProposalEntity(
                trade,
                proposer,
                ProposalStatus.PENDING,
                LocalDateTime.now(),
                proposal.message()
        );

        proposal.items().forEach( c ->items.add(tradeProposalItemMapper.tradeProposalItemToTradeProposalItemEntity(c,trade.getInitiator().getId(),trade.getPartner().getId(),currentUserId,tradeProposal)));
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
                tradeProposalEntity.getTradeItemProposalList().stream().map(tradeProposalItemMapper::tradeProposalItemEntityToTradeItemProposal).toList());
    }

}
