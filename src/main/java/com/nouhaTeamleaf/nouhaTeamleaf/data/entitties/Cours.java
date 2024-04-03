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
@Table(name = "cours")
public class Cours extends AbstractEntity {
    private String nbreHeureGlobal;

    @ManyToOne
    Semestre semestre;
    @ManyToOne
    Professeur professeur;
    @OneToOne
    Module module;
    //fetch = FetchType.EAGER charger les données en meme temps l'entité precedante
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SessionCours> sessionCours;
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Classe> classes;

}
