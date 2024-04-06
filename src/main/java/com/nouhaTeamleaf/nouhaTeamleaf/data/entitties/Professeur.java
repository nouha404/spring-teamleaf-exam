package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;


import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Specialiter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "professeurs")
public class Professeur extends AbstractEntity {
    private String nom;
    private String prenom;
    @Enumerated(value = EnumType.STRING)
    private Specialiter specialite;
    private ENiveau grade;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> cours;
    @OneToMany(mappedBy = "professeur")
    private List<ProfesseurClasse> professeurClasses;

}
