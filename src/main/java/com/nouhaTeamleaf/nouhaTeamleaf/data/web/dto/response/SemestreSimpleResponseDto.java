package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SemestreSimpleResponseDto {
    private Long id;
    private String libelle;
    public static SemestreSimpleResponseDto toDto(Semestre semestre){
        return SemestreSimpleResponseDto.builder()
                .id(semestre.getId())
                .libelle(semestre.getLibelle())
                .build();
    }
}
