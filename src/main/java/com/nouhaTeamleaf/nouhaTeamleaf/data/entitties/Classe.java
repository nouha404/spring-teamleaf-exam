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
@Table(name = "classes")
public class Classe extends AbstractEntity {
    private String libelle;
    private String filiere;
    private Niveau niveau;

    @ManyToOne
    AnneeScolaire anneeScolaire;
    @ManyToOne
    Cours cours;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Professeur> professeurs;



}
