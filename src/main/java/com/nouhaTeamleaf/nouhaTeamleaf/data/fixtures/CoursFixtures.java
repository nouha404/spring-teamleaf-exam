package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(12)
@RequiredArgsConstructor
//@Component
public class CoursFixtures implements CommandLineRunner {
    private final CoursRepository coursRepository;
    private final SemestreRepository semestreRepository;
    private final ClasseRepository classeRepository;
    private final ProfesseurRepository professeurRepository;
    private final ModuleRepository moduleRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {

        List<Classe> classeList = classeRepository.findAll();
        List<Semestre> semestres = semestreRepository.findAll();
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        for (Semestre semestre : semestres) {
            for (Long i = 1L; i < 20L; i++) {
                Professeur professeur = professeurRepository.findById(i).orElse(null);
                Module module = moduleRepository.findById(i).orElse(null);

                Cours cours = new Cours();
                cours.setNbreHeureGlobal("20");
                cours.setEtatCours(i%2==0 ? EtatCours.TERMINER: EtatCours.EN_COURS);
                cours.setIsActive(true);
                cours.setAnneeScolaire(anneeScolaire);

                cours.setModule(module);
                cours.setSemestre(semestre);
                cours.setClasses(classeList);
                cours.setProfesseur(professeur);


                coursRepository.save(cours);
            }
        }

    }
}