package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursClasse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class SessionCoursClasseResponseDto {
    private Long id;
    private Classe classe;
    private SessionCours sessionCours;

    public static SessionCoursClasseResponseDto toDto(SessionCoursClasse sessionCoursClasse) {
        return SessionCoursClasseResponseDto.builder()
                .id(sessionCoursClasse.getId())
                .classe(sessionCoursClasse.getClasse())
                .sessionCours(sessionCoursClasse.getSessionCours())
                .build();
    }
}
