/*package com.nouhaTeamleaf.nouhaTeamleaf.data.entitties;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "heure_planifiee")
public class HeurePlanifiee extends AbstractEntity {

    private Long heurePlanifiee;

    @ManyToOne
    @JoinColumn(name = "cours_id", nullable = false)
    private Cours cours;

}
*/