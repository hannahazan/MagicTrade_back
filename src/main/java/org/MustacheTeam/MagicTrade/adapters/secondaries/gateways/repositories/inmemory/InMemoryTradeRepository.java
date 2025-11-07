package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.TradeRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryTradeRepository implements TradeRepository {


    private final Map<Long, Trade> store = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);


    @Override
    public void save(TradeToSave toSave, Long initiatorId) {
        Long id = seq.getAndIncrement();
        TradeProposalToSave proposalToSave = toSave.proposal();
        TradeProposal proposal = null;
        if (proposalToSave != null) {
            proposal = new TradeProposal(
                    1L,
                    id,
                    initiatorId,
                    "PENDING",
                    LocalDateTime.now(),
                    proposalToSave.message(),
                    List.of()
            );
        }
        Trade trade = new Trade(
                id,
                initiatorId,
                toSave.partnerId(),
                proposal == null ? List.of() : List.of(proposal),
                LocalDateTime.now(),
                null,
                "OPEN"
        );
        store.put(id, trade);
    }


    @Override
    public TradeList findAllTradesByUserId(Long userId) {
        List<Trade> trades = store.values().stream()
                .filter(t -> Objects.equals(t.initiatorId(), userId) || Objects.equals(t.partnerId(), userId))
                .sorted(Comparator.comparing(Trade::id))
                .collect(Collectors.toList());
        return new TradeList(trades);
    }


    @Override
    public Trade findOneTradeById(Long id, Long currentId) {
        return store.get(id);
    }


    @Override
    public void updateStatusTrade(TradeUpdate tradeUpdate, Long userId) {
        Trade existing = store.get(tradeUpdate.tradeId());
        if (existing == null) return;
        Trade updated = new Trade(
                existing.id(),
                existing.initiatorId(),
                existing.partnerId(),
                existing.proposals(),
                existing.creationDate(),
                LocalDateTime.now(),
                tradeUpdate.status()
        );
        store.put(existing.id(), updated);
    }

}