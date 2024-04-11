package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleSimpleResponseDto {
    private Long id;
    private String libelle;

    public static ModuleSimpleResponseDto toDto(Module module){
        return ModuleSimpleResponseDto.builder()
                .id(module.getId())
                .libelle(module.getLibelle())
                .build();
    }
}
