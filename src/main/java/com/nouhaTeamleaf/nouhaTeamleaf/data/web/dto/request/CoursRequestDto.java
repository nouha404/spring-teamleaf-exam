package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursRequestDto {
    private Long id;
    private long nbreHeureGlobal;
    private Semestre semestre;
    private Module module;
    private Professeur professeur;
    private AnneeScolaire anneeScolaire;

    public Cours TransformToEntity(){
        return Cours.builder()
                .nbreHeureGlobal(nbreHeureGlobal)
                .anneeScolaire(new AnneeScolaire())
                .semestre(new Semestre())
                .module(new Module())
                .professeur(new Professeur())
                .build();
    }
}
