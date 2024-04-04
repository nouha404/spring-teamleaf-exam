package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class CoursResponseDto {
    private Long id;
    private String nbreHeureGlobal;
    private String  etatCours;
    private String professeur;
    private String semestre;
    private String module;

    public  static CoursResponseDto toDto(Cours cours) {

        return CoursResponseDto.builder()
                .id(cours.getId())
                .nbreHeureGlobal(cours.getNbreHeureGlobal())
                .semestre(cours.getSemestre().getLibelle())
                .etatCours(cours.getEtatCours().name())
                .professeur(cours.getProfesseur().getNom()+" "+cours.getProfesseur().getPrenom())
                .module(cours.getModule().getLibelle())
                .build();
    }
}
