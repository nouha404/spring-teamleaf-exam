package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.CoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.CoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;


    @Override
    public Page<Cours> getCours(String etat,Pageable page) {
        if (etat != null && !etat.isEmpty()) {
            return coursRepository.findAllByEtatCoursAndActiveTrue(EtatCours.valueOf(etat), page);
        } else {
            return coursRepository.findAllByActiveTrue(page);
        }
        //return coursRepository.findAllByActiveTrue(page);

    }
}
