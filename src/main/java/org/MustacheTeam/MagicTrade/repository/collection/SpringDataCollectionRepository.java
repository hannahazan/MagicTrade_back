package org.MustacheTeam.MagicTrade.repository.collection;

import org.MustacheTeam.MagicTrade.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCollectionRepository extends JpaRepository<Collection, Long> {
}
