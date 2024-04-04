package com.nouhaTeamleaf.nouhaTeamleaf.data.services;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SessionCoursService {
    Page<SessionCours> getSessionCours(Pageable page,String module);
    void validateSessionCours(Long id);
    void inValidateSessionCours(Long id,Long sessionId);

    Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable,Long professorId,String module);
}
