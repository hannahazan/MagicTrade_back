package org.MustacheTeam.MagicTrade.repository.catalog.ability;

import org.MustacheTeam.MagicTrade.model.catalog.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAbilityRepository extends JpaRepository<Ability, Long> {
}
