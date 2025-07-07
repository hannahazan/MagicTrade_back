package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.dto.UserDto;

public interface UserRepository {
    void save (UserDto user);
}
