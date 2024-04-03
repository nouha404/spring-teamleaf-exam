package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import ch.qos.logback.core.net.server.Client;
import com.github.javafaker.Faker;
import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.HIGHEST_PRECEDENCE +3)
@RequiredArgsConstructor
//@Component
public class EtudiantFixtures implements CommandLineRunner {
    private final EtudiantRepository etudiantRepository;
    private final FakerConfig fakerConfig;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 21L; i++) {
            String nomComplet = fakerConfig.faker().name().fullName();
            String matricule = "MAT"+ fakerConfig.faker().numerify("######");
            Etudiant etudiant = new Etudiant(nomComplet,matricule,null);
            etudiant.setActive(true);
            etudiantRepository.save(etudiant);

        }
    }
}
