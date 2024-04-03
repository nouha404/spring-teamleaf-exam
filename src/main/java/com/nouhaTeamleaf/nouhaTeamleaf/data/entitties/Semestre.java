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
@Table(name = "semestres")
public class Semestre extends AbstractEntity{
    private String libelle;

    @ManyToOne
    AnneeScolaire anneeScolaire;
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cours> cours;
    @OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Module> modules;


}
