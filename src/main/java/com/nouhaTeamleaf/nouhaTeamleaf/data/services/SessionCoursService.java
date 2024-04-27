package com.nouhaTeamleaf.nouhaTeamleaf.data.services;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursEtudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.SessionCoursRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalTime;

public interface SessionCoursService {
    Page<SessionCours> getSessionCours(String module,Long professeurId,Pageable page);
    Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable,Long professorId,String module);

    Page<Etudiant> getEtudiantByCours(Long etudiantId, Pageable page);
    void inValidateSessionCours(Long id,Long sessionId);
    void validateSessionCours(Long id,Long sessionId);

    void addSessionCours(SessionCoursRequestDto dto,Long coursId);
    Page<SessionCoursEtudiant> getEtudiantBySessionCours(Long sessionId,Pageable pageable);

    void tester(SessionCoursRequestDto dto);
}
