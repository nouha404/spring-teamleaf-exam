package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursClasse;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursEtudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionCoursEtudiantRepository extends JpaRepository<SessionCoursEtudiant,Long> {
    Page<SessionCoursEtudiant> findSessionCoursEtudiantsByEtudiantAndIsActiveTrue(Long sessionId, Pageable page);
    Page<SessionCoursEtudiant> findBySessionCours(SessionCours sessionCours,Pageable pageable);
}
