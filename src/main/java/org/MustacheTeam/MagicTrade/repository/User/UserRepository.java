package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.model.User;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> getUserById(Long id);
    boolean existsByEmail(String email);
    boolean existsByPseudo(String pseudo);
    Optional<User> findByEmail(String email);
}
