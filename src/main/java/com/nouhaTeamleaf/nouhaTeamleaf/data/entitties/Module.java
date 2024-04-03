package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "modules")
public class Module extends AbstractEntity {
    private String libelle;

    @ManyToOne
    Semestre semestre;

    @OneToOne
    Cours cours;
}
