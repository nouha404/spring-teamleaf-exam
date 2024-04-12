package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
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
    private ETypeSession typeSession;
    private String etatSession;
    private String cours;
    private String salle;
    private String nomComplet;

    private long heuresGlobales;
    private long heuresEffectuees;
    private long heuresRestantes;
    private long nombreHeurePlanifier;
    private long professeurId;

    public  static SessionCoursResponseDto toDto(SessionCours sessionCours) {
        long heuresGlobales = sessionCours.getCours().getNbreHeureGlobal(); //15

        long heuresEffectuees = sessionCours.getCours().getSessionCours().stream()
                .mapToInt(sc -> (int) sc.getNombreHeurePlanifier())
                .sum();

        long heuresRestantes = heuresGlobales - heuresEffectuees;
        long nombreHeurePlanifier = sessionCours.getNombreHeurePlanifier();


        return SessionCoursResponseDto.builder()
                .id(sessionCours.getId())
                .date(sessionCours.getDate())
                .heureDebut(sessionCours.getHeureDebut())
                .heureFin(sessionCours.getHeureFin())
                .heuresGlobales(sessionCours.getCours().getNbreHeureGlobal())
                .heuresEffectuees(heuresEffectuees)
                .heuresRestantes(heuresRestantes)
                .nombreHeurePlanifier(nombreHeurePlanifier)
                .professeurId(sessionCours.getCours().getProfesseur().getId())
                .typeSession(sessionCours.getTypeSession())
                .etatSession(sessionCours.getEtatSession().name())
                .cours(sessionCours.getCours().getModule().getLibelle())
                .build();
    }
}
