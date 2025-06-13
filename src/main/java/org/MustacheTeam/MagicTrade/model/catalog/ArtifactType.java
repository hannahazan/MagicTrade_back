package org.MustacheTeam.MagicTrade.model.catalog;

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
public class ArtifactType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String type;

    public ArtifactType( String artifactType){
        this.type = artifactType;
    }

}
