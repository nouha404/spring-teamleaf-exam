package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Filiere;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.CoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE +7)
@RequiredArgsConstructor
@Component
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final CoursRepository coursRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByActiveTrue();
        List<Cours> coursList = coursRepository.findAll();
        for (long i = 1L; i < 14L; i++) {
            Classe classe = new Classe();
            classe.setLibelle(fakerConfig.faker().funnyName().name());
            classe.setFiliere(Filiere.values()[(int) i % Filiere.values().length].name());
            classe.setNiveau(Niveau.values()[(int) i % Niveau.values().length]);
            classe.setAnneeScolaire(anneeScolaire);
            classe.setCours(coursList.get((int) i % coursList.size()));
            classe.setProfesseurs(null);
            classe.setActive(true);
            classeRepository.save(classe);
        }


    }
}
