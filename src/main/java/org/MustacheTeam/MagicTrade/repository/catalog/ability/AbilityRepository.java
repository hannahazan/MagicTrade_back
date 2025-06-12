package org.MustacheTeam.MagicTrade.repository.catalog.ability;

import org.MustacheTeam.MagicTrade.model.catalog.Ability;

import java.util.List;

public interface AbilityRepository {
    void save(List<String> abilitiesToSave);
    List<String> getAllAbilities();
}
