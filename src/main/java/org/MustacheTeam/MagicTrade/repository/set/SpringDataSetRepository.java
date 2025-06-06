package org.MustacheTeam.MagicTrade.repository.set;

import org.MustacheTeam.MagicTrade.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface SpringDataSetRepository extends JpaRepository<Set, String> {
}
