package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;



@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SessionCoursResponseDto {
    private Long id;
    private Date date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private long nombreHeure;
    private ETypeSession typeSession;
    private String etatSession;
    private String cours;
    private String salle;

    public  static SessionCoursResponseDto toDto(SessionCours sessionCours) {

        return SessionCoursResponseDto.builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .heureDebut(sessionCours.getHeureDebut())
                .heureFin(sessionCours.getHeureFin())
                .nombreHeure(sessionCours.getNombreHeure())
                .typeSession(sessionCours.getTypeSession())
                .etatSession(sessionCours.getTypeSession().name())
                .cours(sessionCours.getCours().getModule().getLibelle())
                .build();
    }

}
