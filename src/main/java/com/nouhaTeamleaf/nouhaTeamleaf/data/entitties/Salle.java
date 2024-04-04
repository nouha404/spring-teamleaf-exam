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
@Table(name = "salles")
public class Salle extends AbstractEntity{
    private String nom;
    private String number;
    private Integer nbrPlace;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SessionCours> sessionCours;
}