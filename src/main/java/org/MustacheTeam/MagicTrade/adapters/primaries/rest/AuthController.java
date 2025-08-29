package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.models.UserLoginDto;
import org.MustacheTeam.MagicTrade.adapters.security.AuthenticationService;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("magicTrade-api/auth")
public class AuthController {

    private final CreateUser createUser;
    private final AuthenticationService authenticationService;

    public AuthController(CreateUser createUser, AuthenticationService authenticationService) {
        this.createUser = createUser;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserDto userDto) {
        Set<String> roles = Set.of("ROLE_USER");
        createUser.handle(userDto, roles);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto userLoginDto) {
        String token = authenticationService.authenticate(
                userLoginDto.getEmail(),
                userLoginDto.getPassword()
        );
        return ResponseEntity.ok(token);
    }
}

