package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;


import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Niveau;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "professeurs")
public class Professeur extends AbstractEntity {
    private String nom;
    private String prenom;
    private String specialite;
    private Niveau grade;

    @ManyToOne
    Classe classe;
    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cours> cours;

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<SessionCours> sessionCours;

}
