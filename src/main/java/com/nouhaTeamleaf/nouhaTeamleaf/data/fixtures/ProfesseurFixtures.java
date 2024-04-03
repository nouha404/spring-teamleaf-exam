package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Filiere;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Specialiter;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.CoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE +8)
@RequiredArgsConstructor
//@Component
public class ProfesseurFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final CoursRepository coursRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByActiveTrue();

        List<Cours> coursList = coursRepository.findAll();

        for (long i = 0L; i < 14L; i++) {
            Professeur professeur = new Professeur();
            professeur.setNom(fakerConfig.faker().name().firstName());
            professeur.setPrenom(fakerConfig.faker().name().lastName());
            professeur.setSpecialite(String.valueOf(Specialiter.values()[(int) (i % Specialiter.values().length)]));
            professeur.setGrade(Niveau.values()[(int) (i % Niveau.values().length)]);

            long finalI = i;
            Classe classe = classeRepository.findById(i).orElseGet(()->{
                Classe classe1 = new Classe();
                classe1.setActive(true);
                classe1.setLibelle(fakerConfig.faker().funnyName().name());
                classe1.setFiliere(Filiere.values()[(int) (finalI % Filiere.values().length)].name());
                classe1.setNiveau(Niveau.values()[(int) (finalI % Niveau.values().length)]);
                classe1.setAnneeScolaire(anneeScolaire);
                classe1.setCours(coursList.get((int) (finalI % coursList.size())));
                classe1.setProfesseurs(null);

                return classeRepository.save(classe1);
            });
            professeur.setClasse(classe);
            professeur.setSessionCours(null);
            professeur.setActive(true);
            professeurRepository.save(professeur);
        }


    }
}
