package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long initiatorId;

    @Column
    private Long partnerId;

    @Column
    private boolean validationInitiator;

    @Column
    private boolean validationPartner;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime clotureDate;

    @Column
    private boolean cloturePartner;

    @Column
    private boolean clotureInitiator;

    @Column
    private boolean warningCloture;

    public TradeEntity(
            Long initiatorId,
            Long partnerId,
            boolean validationInitiator,
            boolean validationPartner,
            LocalDateTime creationDate,
            LocalDateTime clotureDate,
            boolean cloturePartner,
            boolean clotureInitiator,
            boolean warningCloture
    ){
        this.initiatorId = initiatorId;
        this.partnerId = partnerId;
        this.validationInitiator = validationInitiator;
        this.validationPartner = validationPartner;
        this.creationDate = creationDate;
        this.clotureDate = clotureDate;
        this.cloturePartner = cloturePartner;
        this.clotureInitiator = clotureInitiator;
        this.warningCloture = warningCloture;
    }

}
