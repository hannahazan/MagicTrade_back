package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import java.util.List;

public interface AbilityRepository {
    void save(List<String> abilitiesToSave);
    List<String> getAllAbilities();
}
