package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Absence;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AttacheDeClasse;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AbsenceRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AttacheDeClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(Ordered.HIGHEST_PRECEDENCE +11)
@RequiredArgsConstructor
//@Component
public class AttacheDeClasseFixtures implements CommandLineRunner {
    private final AttacheDeClasseRepository attacheDeClasseRepository;
    private final AbsenceRepository absenceRepository;
    private final FakerConfig fakerConfig;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 5L; i++) {
            Absence absence = absenceRepository.findById(i).orElseThrow(() -> new RuntimeException("Attache de classe introuvable"));
            AttacheDeClasse attacheDeClasse = new AttacheDeClasse();
            attacheDeClasse.setActive(true);
            attacheDeClasse.setAbsence(absence);
            attacheDeClasse.setNomComplet(fakerConfig.faker().name().fullName());
            attacheDeClasse.setSessionCours(null);

            attacheDeClasseRepository.save(attacheDeClasse);
        }

    }
}
