package org.MustacheTeam.MagicTrade.repository.set;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.model.Set;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository {
    void save(List<ScryfallSet> setToSave);
}
