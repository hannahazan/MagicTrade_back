package org.MustacheTeam.MagicTrade.corelogics.utils.trade;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class TradeRules {

    public boolean isATradeWithSameTrader(List<Trade> trades,Long idPartner){
        AtomicBoolean exist = new AtomicBoolean(false);
        if(!trades.isEmpty()){
            trades.forEach( t -> {
                if((t.partnerId().equals(idPartner) || t.initiatorId().equals(idPartner)) && t.status().equals("OPEN")){
                    exist.set(true);
                }
            });
        }
        return exist.get();
    }

    public boolean isInitiatorTrader(Long id, Trade trade){
        AtomicBoolean right = new AtomicBoolean(false);
        if(trade.initiatorId().equals(id)){
            right.set(true);
        }
        return right.get();
    }

    public boolean isAllProposingRejectedOrCancelled(List<TradeProposal> proposals){
        AtomicBoolean isAllProposingRejected = new AtomicBoolean(true);
        proposals.forEach(p -> {
            if(Objects.equals(p.status(), "PENDING") || Objects.equals(p.status(), "ACCEPTED")){
                isAllProposingRejected.set(false);
            }
        });
        return isAllProposingRejected.get();
    }

    public boolean isTradeOpen(Trade trade){
        AtomicBoolean open = new AtomicBoolean(false);
        if(trade.status().equals("OPEN")){
            open.set(true);
        }
        return open.get();
    }

    public boolean isNotTheProposer(Long id, TradeProposal tradeProposal){
        AtomicBoolean right = new AtomicBoolean(false);
        if(!Objects.equals(tradeProposal.proposerId(), id)){
            right.set(true);
        }
        return right.get();
    }

    public boolean isAParticipantOfTheTrade(Trade trade, Long id){
        AtomicBoolean participant = new AtomicBoolean(false);
        if(trade.initiatorId().equals(id) || trade.partnerId().equals(id)){
            participant.set(true);
        }
        return  participant.get();
    }

   public boolean isProposalPending(TradeProposal proposal){
       AtomicBoolean pending = new AtomicBoolean(false);
       if(proposal.status().equalsIgnoreCase("PENDING")){
           pending.set(true);
       }
       return pending.get();
   }

   public boolean isCardCollectionFromParticipants(Collection userCard, Long initiatorId, Long partnerId){
        AtomicBoolean belong = new AtomicBoolean(false);
        if(Objects.equals(userCard.userId(), initiatorId) || Objects.equals(userCard.userId(),partnerId)){
            belong.set(true);
        }
        return belong.get();
   }
}
