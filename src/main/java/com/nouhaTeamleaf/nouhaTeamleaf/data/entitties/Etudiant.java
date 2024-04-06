package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ESexe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "etudiants")
public class Etudiant extends AbstractEntity {
    private String nomComplet;
    private String matricule;
    @Enumerated(value = EnumType.STRING)
    private ESexe sexe;
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "etudiant")
    private List<Inscription> inscriptions;
}
