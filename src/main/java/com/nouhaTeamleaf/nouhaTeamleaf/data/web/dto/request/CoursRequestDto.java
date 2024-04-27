package com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursRequestDto {
    private Long id;
    @Positive(message = "Le nombre d'heures global doit être un entier positif supérieur à zéro")
    private long nbreHeureGlobal;
    private Semestre semestre;
    private Module module;
    private Professeur professeur;
    private AnneeScolaire anneeScolaire;
    public Cours TransformToEntity(){
        return Cours.builder()
                .nbreHeureGlobal(nbreHeureGlobal)
                .anneeScolaire(anneeScolaire)
                .semestre(semestre)
                .module(module)
                .professeur(professeur)
                .build();

    }
}
