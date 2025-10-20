package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.GetUserByEmail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magicTrade-api")
public class ProfileController {

    private final GetUserByEmail getUserByEmail;

    public ProfileController(GetUserByEmail getUserByEmail) {
        this.getUserByEmail = getUserByEmail;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        UserDto user = getUserByEmail.handle(email);
        return ResponseEntity.ok(user);
    }
}
