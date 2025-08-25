package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;

import java.util.List;

public interface AbilityRepository {
    void save(List<String> abilitiesToSave);
    Filters getAllAbilities();
}
