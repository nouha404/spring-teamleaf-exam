package com.nouhaTeamleaf.nouhaTeamleaf.data.services;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SessionCoursService {
    Page<SessionCours> getSessionCours(Pageable page,String module);
}
