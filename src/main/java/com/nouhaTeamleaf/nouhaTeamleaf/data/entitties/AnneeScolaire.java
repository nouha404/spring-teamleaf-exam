package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "anneeScolaires")
public class AnneeScolaire extends AbstractEntity {
    private String libelle;
    private LocalDate finDePeriod;

    @OneToMany(mappedBy = "anneeScolaire", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cours> cours;

    @OneToMany(mappedBy = "anneeScolaire", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Inscription> inscriptions;
}
