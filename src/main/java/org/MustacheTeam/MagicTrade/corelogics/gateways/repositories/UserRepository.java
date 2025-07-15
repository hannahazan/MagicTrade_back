package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.UserEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;

import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    void save(UserDto userDto, Set<String> roles);
    Optional<UserEntity> findByEmail(String email);
}
