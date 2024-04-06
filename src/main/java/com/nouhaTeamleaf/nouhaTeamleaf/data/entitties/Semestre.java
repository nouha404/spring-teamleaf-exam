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
    private Niveau niveau;

    @OneToMany(mappedBy = "semestre")
    List<Cours> cours;


}
