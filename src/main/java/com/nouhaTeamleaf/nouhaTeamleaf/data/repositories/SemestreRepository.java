package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    //Semestre findByAnneeScolaire(AnneeScolaire anneeScolaire);
    List<Semestre> findAllByIsActiveTrue();
}
