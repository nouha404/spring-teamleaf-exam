package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    List<Salle> findAllByIsActiveTrue();
}
