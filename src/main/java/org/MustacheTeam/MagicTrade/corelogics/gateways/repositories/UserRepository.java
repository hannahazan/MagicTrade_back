package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.ConnectedUser;
import org.MustacheTeam.MagicTrade.corelogics.models.User;
import org.MustacheTeam.MagicTrade.corelogics.models.UserRegister;
import org.MustacheTeam.MagicTrade.corelogics.models.UserList;

import java.util.Set;

public interface UserRepository {
    void save(UserRegister userDto, Set<String> roles);
    ConnectedUser findUserByEmail(String email);
    UserList findAllUsers();

}
