package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;


import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalMapper;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeToSave;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.TradeRules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TradeMapper extends TradeRules {
   private final TradeProposalMapper tradeProposalMapper;

    public TradeMapper(TradeProposalMapper tradeProposalMapper){
       this.tradeProposalMapper = tradeProposalMapper;
    }

    public Trade tradeEntityToTrade(TradeEntity tradeEntity){
        List<TradeProposal> proposals = new ArrayList<>();
        tradeEntity.getTradeProposalList().forEach(p -> proposals.add(tradeProposalMapper.tradeProposalEntityToTradeProposal(p)));
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

    public TradeEntity tradeToTradeEntity(TradeToSave trade, UserEntity initiator, UserEntity partner, Long id){
        List<TradeProposalEntity> proposalEntityList = new ArrayList<>();
        TradeEntity tradeEntity = new TradeEntity(
                initiator,
                partner,
                LocalDateTime.now(),
                null,
                TradeStatus.OPEN
        );
        proposalEntityList.add(tradeProposalMapper.tradeProposalToTradeProposalEntity(trade.proposal(), tradeEntity, initiator, id));
        tradeEntity.setTradeProposalList(proposalEntityList);
        return tradeEntity;
    }

}
