package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeProposalRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.ProposalUpdate;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalList;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.TradeProposalToSave;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryTradeProposalRepository implements TradeProposalRepository {

    private final Map<Long, TradeProposal> store = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public void save(TradeProposalToSave proposal, Long proposerId) {
        Long id = seq.getAndIncrement();
        TradeProposal saved = new TradeProposal(
                id,
                proposal.tradeId(),
                proposerId,
                "PENDING",
                LocalDateTime.now(),
                proposal.message(),
                List.of()
        );
        store.put(id, saved);
    }

    @Override
    public TradeProposalList getAllTradeProposalByTradeId(Long tradeId, Long currentId) {
        List<TradeProposal> list = store.values().stream()
                .filter(p -> Objects.equals(p.tradeId(), tradeId))
                .sorted(Comparator.comparing(TradeProposal::id))
                .collect(Collectors.toList());
        return new TradeProposalList(list);
    }

    @Override
    public TradeProposal getOneProposalById(Long proposalId, Long currentId) {
        return store.get(proposalId);
    }


    @Override
    public void updateTradeProposalStatus(ProposalUpdate proposal, Long actualProposerId) {
        TradeProposal existing = store.get(proposal.proposalId());
        if (existing == null) return;
        TradeProposal updated = new TradeProposal(
                existing.id(),
                existing.tradeId(),
                existing.proposerId(),
                proposal.proposalStatus(),
                existing.creationDate(),
                existing.message(),
                existing.tradeItemProposals()
        );
        store.put(updated.id(), updated);
    }

}
