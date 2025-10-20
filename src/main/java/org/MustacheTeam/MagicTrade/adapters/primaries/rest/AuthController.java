package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.models.UserLoginDto;
import org.MustacheTeam.MagicTrade.adapters.security.AuthenticationService;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.GetUserByEmail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("magicTrade-api/auth")
public class AuthController {

    private final CreateUser createUser;
    private final AuthenticationService authenticationService;
    private final GetUserByEmail getUserByEmail;

    public AuthController(CreateUser createUser, AuthenticationService authenticationService, GetUserByEmail getUserByEmail) {
        this.createUser = createUser;
        this.authenticationService = authenticationService;
        this.getUserByEmail = getUserByEmail;
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

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        UserDto user = getUserByEmail.handle(email);
        return ResponseEntity.ok(user);
    }
}

