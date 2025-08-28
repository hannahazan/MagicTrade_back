package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item.TradeProposalItemEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.TradeItemProposal;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ProposalStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="trade_proposals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TradeProposalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trade_id", nullable = false)
    private TradeEntity trade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposer_id", nullable = false)
    private UserEntity proposer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProposalStatus status = ProposalStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeProposalItemEntity> tradeItemProposalList;

    private String message;

    public TradeProposalEntity(
            TradeEntity trade,
            UserEntity proposer,
            ProposalStatus status,
            LocalDateTime createdAt,
            String messsage
    ){
        this.trade = trade;
        this.proposer = proposer;
        this.status = status;
        this.createdAt = createdAt;
        this.message = messsage;
    }

}
