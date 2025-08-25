package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface SpringDataSetRepository extends JpaRepository<SetEntity, String> {
}
