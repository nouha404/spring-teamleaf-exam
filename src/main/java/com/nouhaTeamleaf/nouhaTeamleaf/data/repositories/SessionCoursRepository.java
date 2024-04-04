package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {
    Page<SessionCours> findAllByActiveTrue(Pageable page);
    Page<SessionCours> findAllByActiveTrueAndEtatSessionIsTrue(Pageable page) ;
    @Query("SELECT s FROM SessionCours s JOIN s.cours c WHERE c.module.libelle = :module AND s.active = true")
    Page<SessionCours> findByModule(String module, Pageable pageable);

    @Query("SELECT s FROM SessionCours s JOIN s.professeur p WHERE p.id = :professorId AND MONTH(s.date) = MONTH(CURRENT_DATE) AND YEAR(s.date) = YEAR(CURRENT_DATE) AND s.active = true")
    Page<SessionCours> findByProfessorForCurrentMonth(Pageable pageable,Long professorId);

    @Query("SELECT s FROM SessionCours s JOIN s.professeur p JOIN s.cours c WHERE p.id = :professorId AND c.module.libelle = :module AND MONTH(s.date) = MONTH(CURRENT_DATE) AND YEAR(s.date) = YEAR(CURRENT_DATE) AND s.active = true")
    Page<SessionCours> findByProfessorAndModule(Pageable pageable, Long professorId, String module);


}
