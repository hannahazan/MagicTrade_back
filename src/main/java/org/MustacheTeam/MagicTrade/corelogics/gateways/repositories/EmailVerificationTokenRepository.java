package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import java.time.LocalDateTime;

public interface EmailVerificationTokenRepository {
    void createToken(String token, LocalDateTime expireAt, LocalDateTime useAt, Long userId);
    String getToken(Long userId);
}
