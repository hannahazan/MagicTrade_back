package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.UserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.adapters.security.PasswordEncoderService;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;
    private final PasswordEncoderService passwordEncoderService;

    public JpaUserRepository(SpringDataUserRepository repository,PasswordEncoderService passwordEncoder) {
        this.repository = repository;
        this.passwordEncoderService = passwordEncoder;
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByPseudo(String pseudo) {
        return repository.existsByPseudo(pseudo);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void save(UserDto userDto, Set<String> roles) {
        if (existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (existsByPseudo(userDto.getPseudo())) {
            throw new RuntimeException("Pseudo already exists");
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
            user.setRole("USER");
        }
        repository.save(user);
    }


}
