package org.MustacheTeam.MagicTrade.corelogics.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginDto {
    private String email;
    private String password;
}