package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.User;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.models.UserList;

import java.util.Set;

public interface UserRepository {
    void save(UserDto userDto, Set<String> roles);
    User findUserByEmail(String email);
    UserList findAllUsers();

}
