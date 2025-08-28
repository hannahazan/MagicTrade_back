package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection.CollectionEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.proposal.TradeProposalEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.ItemSide;

@Entity
@Table(name = "trade_proposal_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TradeProposalItemEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposal_id", nullable = false)
    private TradeProposalEntity proposal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collection_card_id", nullable = false)
    private CollectionEntity collectionCard;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemSide side;

    public TradeProposalItemEntity(
            TradeProposalEntity proposal,
            CollectionEntity collectionCard,
            ItemSide side
    ){
        this.proposal = proposal;
        this.collectionCard = collectionCard;
        this.side = side;
    }
}
