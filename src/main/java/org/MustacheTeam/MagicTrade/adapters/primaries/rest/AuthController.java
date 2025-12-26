package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.corelogics.models.*;
import org.MustacheTeam.MagicTrade.adapters.security.AuthenticationService;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.GetAllUsers;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.GetUserByEmail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Set;

@RestController
@RequestMapping("magicTrade-api/auth")
public class AuthController {

    private final CreateUser createUser;
    private final AuthenticationService authenticationService;
    private final GetUserByEmail getUserByEmail;
    private final GetAllUsers getAllUsers;

    public AuthController(CreateUser createUser, AuthenticationService authenticationService, GetUserByEmail getUserByEmail, GetAllUsers getAllUsers) {
        this.createUser = createUser;
        this.authenticationService = authenticationService;
        this.getUserByEmail = getUserByEmail;
        this.getAllUsers = getAllUsers;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRegister userDto) {
        Set<String> roles = Set.of("ROLE_USER");
        createUser.handle(userDto, roles);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {
        String token = authenticationService.authenticate(
                userLoginDto.getEmail(),
                userLoginDto.getPassword()
        );

        ResponseCookie cookie = ResponseCookie.from("access_token", token)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("Lax")
                .maxAge(Duration.ofMillis(3600000))
                .build();

        response.addHeader("set-cookie", cookie.toString());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("access_token", "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .sameSite("Lax")
                .maxAge(0)
                .build();

        response.addHeader("Set-Cookie", cookie.toString());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Myprofile")
    public ResponseEntity<ConnectedUser> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        ConnectedUser user = getUserByEmail.handle(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/profiles")
    public ResponseEntity<UserList> getUsers(){
        return ResponseEntity.ok(getAllUsers.handle());
    }

}

