package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class EtudiantResponseDto {
    private Long id;
    private String nomComplet;
    private String matricule;

    public  static EtudiantResponseDto toDto(Etudiant etudiant) {
        return EtudiantResponseDto.builder()
                .id(etudiant.getId())
                .nomComplet(etudiant.getNomComplet())
                .matricule(etudiant.getMatricule())
                .build();
    }
}
