package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.List;

public interface CardNameRepository {
    void save(List<String> cardNameToSave);
    Filters getAllCardNames();
}
