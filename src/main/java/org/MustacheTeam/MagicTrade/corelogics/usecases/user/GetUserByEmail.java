package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.UserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetUserByEmail {

    private final UserRepository repository;

    public GetUserByEmail(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public UserDto handle(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email '" + email + "' not found"));

        var dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setCity(user.getCity());
        dto.setCountry(user.getCountry());
        dto.setPseudo(user.getPseudo());
        dto.setDepartment(user.getDepartment());
        return dto;
    }
}
