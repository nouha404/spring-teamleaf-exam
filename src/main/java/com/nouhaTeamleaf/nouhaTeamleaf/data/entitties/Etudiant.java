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
@Table(name = "etudiants")
public class Etudiant extends AbstractEntity {
    private String nomComplet;
    private String matricule;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Absence> absences;

}
