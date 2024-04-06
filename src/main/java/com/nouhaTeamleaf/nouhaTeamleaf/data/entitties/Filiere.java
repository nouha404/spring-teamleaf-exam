package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EFiliere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "filieres")
public class Filiere extends AbstractEntity {
    @Enumerated(value = EnumType.STRING)
    private EFiliere eFiliere;
    @OneToMany(mappedBy = "filiere")
    List<Classe> classes;


}
