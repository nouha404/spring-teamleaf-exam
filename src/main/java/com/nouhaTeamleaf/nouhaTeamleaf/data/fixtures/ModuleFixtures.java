package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE +5)
@RequiredArgsConstructor
//@Component
public class ModuleFixtures implements CommandLineRunner {
    private final ModuleRepository moduleRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByActiveTrue();

        List<Semestre> semestres = anneeScolaire.getSemestres();

        for (Semestre smtre : semestres){
            for (long i = 1L; i < 16L; i++) {
                Module module = new Module();
                String libelle = fakerConfig.faker().programmingLanguage().name();

                module.setLibelle(libelle);
                module.setActive(true);
                module.setCours(null);
                module.setSemestre(smtre);
                module.setActive(true);
                moduleRepository.save(module);

            }

        }


    }
}
