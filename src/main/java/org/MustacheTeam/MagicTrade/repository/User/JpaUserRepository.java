package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;

public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepository(SpringDataUserRepository springDataUserRepository){
        this.repository = springDataUserRepository;
    }

    public void save(UserDto user){
        repository.save(new User(user.email(), user.pseudo(), user.name(), user.subName(), user.postalCode()));
    }
}
