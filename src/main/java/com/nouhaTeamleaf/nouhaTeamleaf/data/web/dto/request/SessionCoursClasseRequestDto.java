package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionCoursClasseRequestDto {
    private Long id;
    private Classe classe;
    private SessionCours sessionCours;


    public SessionCoursClasse TransformToEntity(){
        return SessionCoursClasse.builder()
                .classe(new Classe())
                .sessionCours(new SessionCours())
                .build();
    }
}
