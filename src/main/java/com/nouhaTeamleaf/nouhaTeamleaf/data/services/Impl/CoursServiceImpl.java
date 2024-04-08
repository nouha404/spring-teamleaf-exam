package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Inscription;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.CoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.CoursService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    @Override
    public Page<Cours> getCours(String etatCours, Pageable page) {
        if (etatCours != null && !etatCours.isEmpty()) {
            return coursRepository.findAllByEtatCoursAndIsActiveTrue(EtatCours.valueOf(etatCours), page);
        } else {
            return coursRepository.findAllByIsActiveTrue(page);
        }
    }

    @Override
    public Page<Etudiant> getEtudiantsByCours(Long coursId, Pageable pageable) {
        return null;
    }
}
