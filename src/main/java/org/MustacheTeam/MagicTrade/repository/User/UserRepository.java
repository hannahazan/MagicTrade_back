package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;

public interface UserRepository {
    void save (UserDto user);

    User getUserById(Long id);
}
