package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    void save(UserDto userDto, Set<String> roles);
    Optional<User> findByEmail(String email);
}
