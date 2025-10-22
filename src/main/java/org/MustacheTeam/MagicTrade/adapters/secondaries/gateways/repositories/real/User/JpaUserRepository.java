package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.UserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.User;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.adapters.security.PasswordEncoderService;
import org.MustacheTeam.MagicTrade.corelogics.models.UserList;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceAlreadyExistsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;
    private final PasswordEncoderService passwordEncoderService;

    public JpaUserRepository(SpringDataUserRepository repository, PasswordEncoderService passwordEncoder) {
        this.repository = repository;
        this.passwordEncoderService = passwordEncoder;
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByPseudo(String pseudo) {
        return repository.existsByPseudo(pseudo);
    }

    @Override
    public UserList findAllUsers(){
        List<UserEntity> userEntities = repository.findAll();
        List<User> users = new ArrayList<>();
        userEntities.forEach(u ->
            users.add(new User(
                    u.getId(),
                    u.getPseudo(),
                    u.getCountry(),
                    u.getDepartment(),
                    u.getCity()
            ))
        );
        return new UserList(users);
    }

    @Override
    public User findUserByEmail(String email) {
      UserEntity userEntity = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
      return new User(userEntity.getId(),
              userEntity.getPseudo(),
              userEntity.getCountry(),
              userEntity.getDepartment(),
              userEntity.getCity());
    }

    @Override
    public void save(UserDto userDto, Set<String> roles) {
        if (existsByEmail(userDto.getEmail())) {
            throw new ResourceAlreadyExistsException("user", "email");
        }

        if (existsByPseudo(userDto.getPseudo())) {
            throw new ResourceAlreadyExistsException("user", "pseudo");
        }

        String hashedPassword = passwordEncoderService.encode(userDto.getPassword());

        UserEntity user = new UserEntity(
                userDto.getEmail(),
                userDto.getPseudo(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getCountry(),
                userDto.getDepartment(),
                userDto.getCity(),
                hashedPassword
        );

        if (!roles.isEmpty()) {
            user.setRole(roles.iterator().next());
        } else {
            user.setRole("ROLE_USER");
        }

        repository.save(user);
    }
}
