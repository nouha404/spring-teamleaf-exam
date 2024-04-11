package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Specialiter;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesseurSimpleResponseDto {
    private Long id;
    private String nomComplet;

    public static ProfesseurSimpleResponseDto toDto(Professeur professeur){
        return ProfesseurSimpleResponseDto.builder()
                .id(professeur.getId())
                .nomComplet(professeur.getPrenom()+" "+professeur.getNom())
                .build();
    }

}
