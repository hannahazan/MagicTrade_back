package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository {
    void save(List<ScryfallSet> setToSave);
}
