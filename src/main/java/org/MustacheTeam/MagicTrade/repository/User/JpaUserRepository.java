package org.MustacheTeam.MagicTrade.repository.User;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;

public class JpaUserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepository(SpringDataUserRepository springDataUserRepository){
        this.repository = springDataUserRepository;
    }

    public User save(User user){
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id){
        return repository.findUserById(id);
    }

}
