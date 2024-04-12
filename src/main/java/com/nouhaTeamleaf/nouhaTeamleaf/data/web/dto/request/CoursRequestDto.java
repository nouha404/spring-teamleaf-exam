package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
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
    //@NotBlank(message = "Le nom est obligatoire")
    private long nbreHeureGlobal;
    //@NotNull(message = "Ce Champ est requis.")
    private Semestre semestre;
    //@NotNull(message = "Ce Champ est requis.")
    private Module module;
    //@NotNull(message = "Ce Champ est requis.")
    private Professeur professeur;
    //@NotNull(message = "Ce Champ est requis.")
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
