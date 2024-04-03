package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.TypeSession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sessionCours")
public class SessionCours extends AbstractEntity {
    private Date date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private long nombreHeure;
    private TypeSession typeSession;
    @ManyToOne
    Cours cours;
    @ManyToOne
    Salle salle;
    @ManyToOne
    Professeur professeur;
    @ManyToOne
    AttacheDeClasse attacheDeClasse;
    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Absence> absences;
}
