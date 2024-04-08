package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ETypeSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Order(14)
@RequiredArgsConstructor
//@Component
public class SessionCoursFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    private final CoursRepository coursRepository;
    private final SalleRepository salleRepository;

    @Override
    public void run(String... args) throws Exception {

        for (Long i = 1L; i < 20L; i++) {
            LocalTime heureDebut = LocalTime.parse("08:00:00");
            LocalTime heureFin = LocalTime.parse("17:00:00");
            ETypeSession typeSession = (i % 2 == 0 ? ETypeSession.PRESENTIEL : ETypeSession.EN_LIGNE);
            SessionCours sessionCours = new SessionCours();
            sessionCours.setDate(new Date());
            sessionCours.setIsActive(true);
            sessionCours.setHeureDebut(heureDebut);
            sessionCours.setHeureFin(heureFin);

            Duration duration = Duration.between(heureDebut, heureFin);
            long nombreHeure = duration.toHours();
            sessionCours.setNombreHeure(nombreHeure);

            sessionCours.setTypeSession(typeSession);
            sessionCours.setEtatSession(i%2==0? EEtatSession.VALIDER : EEtatSession.INVALIDER);

            Cours cours = coursRepository.findById(i).orElse(null);
            Salle salle = salleRepository.findById(i).orElse(null);
            sessionCours.setCours(cours);
            sessionCours.setSalle(salle);

            sessionCoursRepository.save(sessionCours);
        }

    }
}