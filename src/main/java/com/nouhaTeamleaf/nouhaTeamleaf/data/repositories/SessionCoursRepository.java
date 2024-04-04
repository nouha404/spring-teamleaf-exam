package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {
    Page<SessionCours> findAllByActiveTrue(Pageable page);
    @Query("SELECT s FROM SessionCours s JOIN s.cours c WHERE c.module.libelle = :module AND s.active = true")
    Page<SessionCours> findByModule(String module, Pageable pageable);

}
