package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class CoursResponseDto {
    private Long id;
    private long nbreHeureGlobal;
    private EtatCours  etatCours;
    private String semestre;
    private String module;
    private Long moduleId;

    private long nombreHeurePlanifier;
    private LocalTime heuresEffectuees;
    private long heuresRestantes;

    private String professeur;
    private String nomComplet;

    private ProfesseurSimpleResponseDto professeurDto;

    public  static CoursResponseDto toDto(Cours cours) {

        return CoursResponseDto.builder()
                .id(cours.getId())
                .nbreHeureGlobal(cours.getNbreHeureGlobal())
                .semestre(cours.getSemestre().getLibelle())
                .etatCours(cours.getEtatCours())
                .module(cours.getModule().getLibelle())
                .moduleId(cours.getModule().getId())
                .nombreHeurePlanifier(cours.getNombreHeurePlanifier())
                .heuresEffectuees(cours.getHeuresEffectuees())
                .heuresRestantes(cours.getNbreHeureGlobal())
                .build();
    }

    public  static CoursResponseDto toDetailDto(Cours cours){
        ProfesseurSimpleResponseDto professeurDto = ProfesseurSimpleResponseDto.toDto(cours.getProfesseur());

        return CoursResponseDto.builder()
                .id(cours.getId())
                .nbreHeureGlobal(cours.getNbreHeureGlobal())
                .professeur(professeurDto.getNomComplet())
                .nombreHeurePlanifier(cours.getNombreHeurePlanifier())
                .heuresEffectuees(cours.getHeuresEffectuees())
                .heuresRestantes(cours.getHeuresRestantes())
                .build();
    }


}
