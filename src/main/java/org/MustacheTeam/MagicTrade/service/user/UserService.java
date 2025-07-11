package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;

import java.util.Set;

public interface UserService {
    User createUser(UserDto userDto, Set<String> roles);
}
