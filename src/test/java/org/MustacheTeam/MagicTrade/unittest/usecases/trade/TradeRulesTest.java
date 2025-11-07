package org.MustacheTeam.MagicTrade.unittest.usecases.trade;

import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.utils.trade.TradeRules;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeRulesTest {

    private final TradeRules rules = new TradeRules();


    private Trade openTrade(Long id, Long initiator, Long partner){
        return new Trade(id, initiator, partner, List.of(), LocalDateTime.now(), null, "OPEN");
    }

    private TradeProposal proposal(Long id, Long tradeId, Long proposer, String status){
        return new TradeProposal(id, tradeId, proposer, status, LocalDateTime.now(), null, List.of());
    }

    @Test
    void isATradeWithSameTrader_returns_false_when_no_open_trade_with_partner(){
        var closed = new Trade(1L, 10L, 20L, List.of(), LocalDateTime.now(), LocalDateTime.now(), "CLOSED");
        boolean exist = rules.isATradeWithSameTrader(List.of(closed), 20L);
        assertThat(exist).isFalse();
    }


    @Test
    void isInitiatorTrader_checks_initiator(){
        var t = openTrade(1L, 10L, 20L);
        assertThat(rules.isInitiatorTrader(10L, t)).isTrue();
        assertThat(rules.isInitiatorTrader(20L, t)).isFalse();
    }


    @Test
    void isAllProposingRejectedOrCancelled_true_when_all_not_pending_or_accepted(){
        var p1 = proposal(1L, 1L, 10L, "REJECTED");
        var p2 = proposal(2L, 1L, 11L, "CANCELLED");
        assertThat(rules.isAllProposingRejectedOrCancelled(List.of(p1, p2))).isTrue();
    }


    @Test
    void isAllProposingRejectedOrCancelled_false_when_one_pending(){
        var p1 = proposal(1L, 1L, 10L, "PENDING");
        assertThat(rules.isAllProposingRejectedOrCancelled(List.of(p1))).isFalse();
    }


    @Test
    void isTradeOpen_matches_status_open(){
        assertThat(rules.isTradeOpen(openTrade(1L, 10L, 20L))).isTrue();
    }


    @Test
    void isNotTheProposer_true_when_ids_differ(){
        var p = proposal(1L, 1L, 10L, "PENDING");
        assertThat(rules.isNotTheProposer(11L, p)).isTrue();
        assertThat(rules.isNotTheProposer(10L, p)).isFalse();
    }


    @Test
    void isAParticipantOfTheTrade_true_when_user_is_initiator_or_partner(){
        var t = openTrade(1L, 100L, 200L);
        assertThat(rules.isAParticipantOfTheTrade(t, 100L)).isTrue();
        assertThat(rules.isAParticipantOfTheTrade(t, 200L)).isTrue();
        assertThat(rules.isAParticipantOfTheTrade(t, 300L)).isFalse();
    }


    @Test
    void isProposalPending_true_when_status_is_pending(){
        var p = proposal(1L, 1L, 10L, "PENDING");
        assertThat(rules.isProposalPending(p)).isTrue();
        var p2 = proposal(2L, 1L, 10L, "ACCEPTED");
        assertThat(rules.isProposalPending(p2)).isFalse();
    }


}
