package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
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

    private long nombreHeurePlanifier;
    private LocalTime heuresEffectuees;
    private LocalTime heuresRestantes;

    private ETypeSession typeSession;
    private EEtatSession etatSession;

    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    private List<SessionCoursClasse> sessionCoursClasses;

    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    List<Absence> absences;

    @ManyToOne
    Cours cours;
    @ManyToOne
    Salle salle;
    @OneToMany(mappedBy = "sessionCours", cascade = CascadeType.ALL)
    private List<SessionCoursEtudiant> sessionCoursEtudiants;


}
