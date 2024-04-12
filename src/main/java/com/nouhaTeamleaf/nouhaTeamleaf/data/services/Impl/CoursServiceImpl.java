package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.CoursService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.ProfesseurService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.CoursRequestDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    private final ModulesRepository modulesRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ProfesseurRepository professeurRepository;
    private final SemestreRepository semestreRepository;
    @Override
    public Page<Cours> getCours(String etatCours, Pageable page) {
        if (etatCours != null && !etatCours.isEmpty()) {
            return coursRepository.findAllByEtatCoursAndIsActiveTrue(EtatCours.valueOf(etatCours), page);
        } else {
            return coursRepository.findAllByIsActiveTrue(page);
        }
    }

    @Override
    public List<Cours> getCours() {
        return coursRepository.findAllByIsActiveTrue();
    }

    @Override
    public void addCours(CoursRequestDto dto) {
        Cours cours = dto.TransformToEntity();
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        cours.setAnneeScolaire(anneeScolaire);
        cours.setModule(dto.getModule());
        cours.setSemestre(dto.getSemestre());
        cours.setProfesseur(dto.getProfesseur());
        cours.setIsActive(true);
        cours.setEtatCours(EtatCours.EN_COURS);
        cours.setNbreHeureGlobal(dto.getNbreHeureGlobal());
        coursRepository.save(cours);
    }

    @Override
    public List<Module> getModules() {
        return modulesRepository.findAll();
    }

}
