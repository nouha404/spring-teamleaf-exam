package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    List<Classe> findAllByIsActiveTrue();
}
