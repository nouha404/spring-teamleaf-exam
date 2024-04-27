package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByEtatCoursAndIsActiveTrue(EtatCours etatCours, Pageable pageable);
    Page<Cours> findAllByIsActiveTrue(Pageable page);
    List<Cours> findAllByIsActiveTrue();
    Cours findByIdAndIsActiveTrue(Long id);

    @Modifying
    @Query("UPDATE Cours c SET c.nombreHeurePlanifier = c.nombreHeurePlanifier + :heureToAdd WHERE c.id = :coursId")
    void addHeurePlanifier(@Param("coursId") Long coursId, @Param("heureToAdd") Long heureToAdd);

}
