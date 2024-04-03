package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.HIGHEST_PRECEDENCE +4)
@RequiredArgsConstructor
//@Component
public class SemestreFixtures implements CommandLineRunner {
    private final SemestreRepository semestreRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByActiveTrue();
        for (long i = 1L; i < 11L; i++) {
            Semestre semestre = new Semestre();
            semestre.setLibelle("Semestre "+i);

            semestre.setAnneeScolaire(anneeScolaire);
            semestre.setModules(null);
            semestre.setCours(null);
            semestre.setActive(true);
            semestreRepository.save(semestre);


        }
    }
}
