package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "attacheDeClasses")
public class AttacheDeClasse extends AbstractEntity {
    private String nomComplet;
    @ManyToOne
    Absence absence;

    @OneToMany(mappedBy = "attacheDeClasse", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SessionCours> sessionCours;
}
