package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.Specialiter;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(10)
@RequiredArgsConstructor
//@Component
public class ProfesseurFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final ProfesseurClasseRepository professeurClasseRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 20L; i++) {
            List<ProfesseurClasse> professeurClasseList = professeurClasseRepository.findAll();
            Professeur professeur = new Professeur();

            professeur.setNom(fakerConfig.faker().name().firstName());
            professeur.setPrenom(fakerConfig.faker().name().lastName());
            professeur.setGrade(ENiveau.values()[(int) (i % ENiveau.values().length)]);
            professeur.setSpecialite(Specialiter.values()[(int) (i% Specialiter.values().length)]);
            professeur.setProfesseurClasses(professeurClasseList);
            professeur.setIsActive(true);
            professeurRepository.save(professeur);
        }


    }
}