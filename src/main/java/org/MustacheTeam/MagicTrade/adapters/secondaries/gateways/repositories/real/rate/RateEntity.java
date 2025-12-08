package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.rate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;

@Entity
@Table(name = "rates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer  rate;

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rated_user_id",  referencedColumnName = "id", nullable = false)
    private UserEntity userRated;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rater_user_id",  referencedColumnName = "id", nullable = false)
    private UserEntity userRater;

    public RateEntity(Integer rate, String message, UserEntity userRated, UserEntity userRater) {
        this.rate = rate;
        this.message = message;
        this.userRated = userRated;
        this.userRater = userRater;
    }

}
