package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;


/*
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
    private ETypeSession ETypeSession;
    private String cours;
    private long professeur;
    private String nomComplet;

    public  static SessionCoursResponseDto toDto(SessionCours sessionCours) {

        return SessionCoursResponseDto.builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .heureDebut(sessionCours.getHeureDebut())
                .nomComplet(sessionCours.getProfesseur().getNom()+" "+sessionCours.getProfesseur().getPrenom())
                .heureFin(sessionCours.getHeureFin())
                .nombreHeure(sessionCours.getNombreHeure())
                .ETypeSession(sessionCours.getETypeSession())
                .cours(sessionCours.getCours().getModule().getLibelle())
                .professeur(sessionCours.getProfesseur().getId())
                .build();
    }

}*/
