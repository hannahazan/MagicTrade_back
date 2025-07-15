package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.artifacttype;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artifactTypes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtifactTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String type;

    public ArtifactTypeEntity(String artifactType){
        this.type = artifactType;
    }

}
