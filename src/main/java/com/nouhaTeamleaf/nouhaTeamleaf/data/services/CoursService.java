package com.nouhaTeamleaf.nouhaTeamleaf.data.services;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoursService {
    Page<Cours> getCours(String etatCours, Pageable page);
}
