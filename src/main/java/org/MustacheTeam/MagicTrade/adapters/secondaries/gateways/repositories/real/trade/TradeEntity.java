package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.TradeStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "trades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "initiator_id", nullable = false)
    private UserEntity initiator;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "partner_id", nullable = false)
    private UserEntity partner;

    @OneToMany(mappedBy = "trade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeProposalEntity> tradeProposalList;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime clotureDate;

    @Enumerated(EnumType.STRING)
    @Column
    private TradeStatus status = TradeStatus.OPEN;

    public TradeEntity(
            UserEntity initiatorId,
            UserEntity partnerId,
            LocalDateTime creationDate,
            LocalDateTime clotureDate,
            TradeStatus status
    ){
        this.initiator = initiatorId;
        this.partner = partnerId;
        this.creationDate = creationDate;
        this.clotureDate = clotureDate;
        this.status = status;
    }

}
