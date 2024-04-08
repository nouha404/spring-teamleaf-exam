package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import org.springframework.data.jpa.repository.Query;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByEtatCoursAndIsActiveTrue(EtatCours etatCours, Pageable pageable);
    Page<Cours> findAllByIsActiveTrue(Pageable page);
}
