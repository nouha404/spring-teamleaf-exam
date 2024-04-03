package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.CoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE +6)
@RequiredArgsConstructor
//@Component
public class CoursFixtures implements CommandLineRunner {
    private final CoursRepository coursRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ModuleRepository moduleRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {

        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByActiveTrue();
        List<Semestre> semestres = anneeScolaire.getSemestres();

        for (Semestre semestre : semestres) {
            for (Long i = 1L; i < 10L; i++) {
                Cours cours = new Cours();

                Module module = moduleRepository.findById(i).orElseGet(()->{
                    Module newModule = new Module();
                    newModule.setLibelle(fakerConfig.faker().book().title());
                    return moduleRepository.save(newModule);
                });

                cours.setNbreHeureGlobal("20");
                cours.setSemestre(semestre);
                cours.setModule(module);

                cours.setClasses(null);
                cours.setSessionCours(null);
                cours.setActive(true);

                coursRepository.save(cours);
            }
        }

    }
}
