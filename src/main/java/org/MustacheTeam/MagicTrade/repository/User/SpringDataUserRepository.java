package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u Where u.id = ?1")
    User findUserById(Long id);
}
