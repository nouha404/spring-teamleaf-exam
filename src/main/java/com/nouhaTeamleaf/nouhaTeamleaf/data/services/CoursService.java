package com.nouhaTeamleaf.nouhaTeamleaf.data.services;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.CoursRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoursService {
    Page<Cours> getCours(String etatCours, Pageable page);
    List<Cours> getCours();

    void addCours(CoursRequestDto dto);
    List<Module> getModules();

}
