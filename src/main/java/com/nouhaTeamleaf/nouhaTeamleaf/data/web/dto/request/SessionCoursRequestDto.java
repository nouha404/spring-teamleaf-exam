package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
//import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionCoursRequestDto {
    private Long id;
    //@Future(message = "Entrez une date valide.")
    private Date date;
    //@NotNull(message = "Champ requis.")
    private LocalTime heureDebut;
    //@NotNull(message = "Champ requis.")
    private LocalTime heureFin;
    //@NotNull(message = "Champ requis.")
    private ETypeSession typeSession;
    //@NotNull(message = "Champ requis.")
    private EEtatSession etatSession;
    //@NotNull(message = "Champ requis.")
    private Cours cours;
    // @NotNull(message = "Champ requis.")
    private Salle salle;
    private List<SessionCoursClasse> sessionCoursClasses;
    public SessionCours TransformToEntity(){
        Duration duration = Duration.between(heureDebut, heureFin);

        return SessionCours.builder()
                .date(date)
                .heureDebut(heureDebut)
                .heureFin(heureFin)
                .etatSession(EEtatSession.INVALIDER)
                .nombreHeurePlanifier(duration.toHours())
                .sessionCoursClasses(sessionCoursClasses)
                .typeSession(typeSession)
                .cours(new Cours())
                .salle(new Salle())
                .build();
    }
}
