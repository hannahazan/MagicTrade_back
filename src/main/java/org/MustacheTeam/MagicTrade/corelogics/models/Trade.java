package org.MustacheTeam.MagicTrade.corelogics.models;

import java.time.LocalDateTime;

public record Trade(
        Long id,
        Long initiatorId,
        Long partnerId,
        boolean validationInitiator,
        boolean validationPartner,
        LocalDateTime creationDate,
        LocalDateTime clotureDate,
        boolean clotureInitiator,
        boolean cloturePartner,
        boolean warningCloture
) {
}
