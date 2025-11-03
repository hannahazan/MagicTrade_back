package org.MustacheTeam.MagicTrade.corelogics.models.trader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TraderPreview {
    private Long id;
    private String pseudo;
    private String city;
    private String country;
    private String department;
    private Long collectionCount;
}
