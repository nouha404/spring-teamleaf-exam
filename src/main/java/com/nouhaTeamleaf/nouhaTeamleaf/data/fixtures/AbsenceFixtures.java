package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Absence;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.StatusAbsence;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AbsenceRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.EtudiantRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Order(Ordered.HIGHEST_PRECEDENCE +10)
@RequiredArgsConstructor
//@Component
public class AbsenceFixtures implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i < 5L; i++) {
            SessionCours sessionCours = sessionCoursRepository.findById(i).orElseThrow(() -> new RuntimeException("Session de cours introuvable"));
            Etudiant etudiant = etudiantRepository.findById(i).orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

            Absence absence = new Absence();
            absence.setDateAbsence(new Date());
            absence.setHeureAbsence(LocalTime.now());
            absence.setMotif("Maladie");
            absence.setStatusAbsence(StatusAbsence.JUSTIFIER);
            absence.setEtudiant(etudiant);
            absence.setSessionCours(sessionCours);
            absence.setActive(true);
            absence.setMotif("Retard");
            absence.setAttacheDeClasses(null);

            absenceRepository.save(absence);

        }

    }
}
