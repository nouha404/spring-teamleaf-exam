package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "cours")
public class Cours extends AbstractEntity {
    private String nbreHeureGlobal;
    private EtatCours etatCours;

    @ManyToOne
    private Semestre semestre;

    @OneToMany(mappedBy = "cours")
    private List<Classe> classes;
    @ManyToOne
    private Module module;
    @OneToMany(mappedBy = "cours")
    private List<SessionCours> sessionCours;
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private AnneeScolaire anneeScolaire;

}
