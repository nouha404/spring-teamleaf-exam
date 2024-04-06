package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessionCours_classe")
public class SessionCoursClasse extends AbstractEntity{
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private SessionCours sessionCours;
}
