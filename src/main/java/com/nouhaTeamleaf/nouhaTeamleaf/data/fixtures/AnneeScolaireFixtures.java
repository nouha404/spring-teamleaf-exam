package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;


import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@RequiredArgsConstructor
//@Component
public class AnneeScolaireFixtures implements CommandLineRunner {
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (int year = 2019; year <= 2025; year++) {
            LocalDate debutDePeriod = LocalDate.of(year, 9, 1);
            LocalDate finDePeriod = debutDePeriod.plusYears(1).minusDays(1);

            AnneeScolaire anneeScolaire = new AnneeScolaire();
            if (year==2024){
                anneeScolaire.setActive(true);
            }
            anneeScolaire.setActive(false);
            anneeScolaire.setLibelle(year + "-" + (year + 1));
            anneeScolaire.setFinDePeriod(finDePeriod);

            anneeScolaireRepository.save(anneeScolaire);
        }
        }

    }
