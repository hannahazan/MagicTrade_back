package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.repository.User.JpaUserRepository;
import org.MustacheTeam.MagicTrade.repository.User.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreateUser implements UserService {

    private final JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public CreateUser(JpaUserRepository jpaUserRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto, Set<String> roles) {
        if (userRepository.existsByEmail(userDto.email())) {
            throw new RuntimeException("Email already exists");
        }

        String hashedPassword = passwordEncoder.encode(userDto.password());

        User user = new User(
                userDto.email(),
                userDto.pseudo(),
                userDto.name(),
                userDto.subName(),
                userDto.postalCode(),
                hashedPassword
        );

        if (!roles.isEmpty()) {
            user.setRole(roles.iterator().next());
        } else {
            user.setRole("USER");
        }

        if (userRepository.existsByPseudo(userDto.pseudo())) {
            throw new RuntimeException("Pseudo already exists");
        }

        return jpaUserRepository.save(user);
    }
}
