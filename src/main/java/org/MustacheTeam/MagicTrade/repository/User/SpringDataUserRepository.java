package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
}
