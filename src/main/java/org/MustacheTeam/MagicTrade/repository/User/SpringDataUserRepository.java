package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping
public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    @Query(value = "SELECT u FROM User u Where u.id = ?1")
    User findUserById(Long id);
}
