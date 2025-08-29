package org.MustacheTeam.MagicTrade.corelogics.models;

import org.springframework.security.core.GrantedAuthority;

import java.util.Iterator;

public record Collection(Long id,
           Long userId,
           String cardId,
           String lang,
           String state
){}
