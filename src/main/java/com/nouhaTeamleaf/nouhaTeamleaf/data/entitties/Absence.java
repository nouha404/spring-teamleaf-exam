package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.StatusAbsence;
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
@Table(name = "absences")
public class Absence extends AbstractEntity {
    private Date dateAbsence;
    private LocalTime heureAbsence;
    private String motif;
    private StatusAbsence statusAbsence;
    @ManyToOne
    SessionCours sessionCours;
    @ManyToOne
    Etudiant etudiant;

}
