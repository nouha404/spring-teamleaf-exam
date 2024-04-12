package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ClasseSimpleResponseDto {
    private Long id;
    private String libelle;

    public static ClasseSimpleResponseDto toDto(Classe classe) {
        return ClasseSimpleResponseDto.builder()
                .id(classe.getId())
                .libelle(classe.getNiveau().getLibelle()+classe.getFiliere().getEFiliere().name())
                .build();
    }
}
