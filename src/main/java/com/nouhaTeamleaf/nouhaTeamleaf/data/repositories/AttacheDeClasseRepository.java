package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AttacheDeClasse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttacheDeClasseRepository extends JpaRepository<AttacheDeClasse,Long> {
    AttacheDeClasse findByActiveTrue();
}
