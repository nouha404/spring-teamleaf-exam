package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Salle;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
//@Component
public class SalleFixtures implements CommandLineRunner {
    private final SalleRepository salleRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 14L; i++) {
            Salle salle = new Salle();
            salle.setNom("Salle "+i);
            salle.setNumber(fakerConfig.faker().numerify("###"));
            salle.setNbrPlace(fakerConfig.faker().number().numberBetween(20, 41));

            salle.setSessionCours(null);
            salle.setActive(true);
            salleRepository.save(salle);

        }

    }
}
