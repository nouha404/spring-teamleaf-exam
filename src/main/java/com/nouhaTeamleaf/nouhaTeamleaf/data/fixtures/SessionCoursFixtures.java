package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.TypeSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE +9)
@RequiredArgsConstructor
//@Component
public class SessionCoursFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final ProfesseurRepository professeurRepository;
    private final CoursRepository coursRepository;
    private final SalleRepository salleRepository;
    private final AttacheDeClasseRepository attacheDeClasseRepository;

    @Override
    public void run(String... args) throws Exception {
        for (Long i = 1L; i < 10L; i++) {
            LocalTime heureDebut = LocalTime.parse("08:00:00");
            LocalTime heureFin = LocalTime.parse("17:00:00");
            TypeSession typeSession = (i % 2 == 0) ? TypeSession.PRESENTIEL : TypeSession.EN_LIGNE;

            Cours cours = coursRepository.findById(i).orElseGet(() ->{
                Cours cours1 = new Cours();
                return coursRepository.save(cours1);
            });
            Professeur professeur = professeurRepository.findById(i).orElseGet(() -> {
                Professeur newProfesseur = new Professeur();
                return professeurRepository.save(newProfesseur);
            });;
            Salle salle = salleRepository.findById(i).orElseGet(() ->{
                Salle salle1 =new Salle();
                return salleRepository.save(salle1);
            });

            SessionCours sessionCours = new SessionCours();
            sessionCours.setDate(new Date());
            sessionCours.setActive(true);
            sessionCours.setHeureDebut(heureDebut);
            sessionCours.setHeureFin(heureFin);

            Duration duration = Duration.between(heureDebut, heureFin);
            long nombreHeure = duration.toHours();
            sessionCours.setTypeSession(typeSession);
            sessionCours.setCours(cours);
            sessionCours.setProfesseur(professeur);
            sessionCours.setSalle(salle);
            sessionCours.setNombreHeure(nombreHeure);
            sessionCours.setAbsences(null);


            AttacheDeClasse attacheDeClasse = attacheDeClasseRepository.findById(i).orElseGet(()->{
                    AttacheDeClasse attch = new AttacheDeClasse();
            return attacheDeClasseRepository.save(attch);
            });
            sessionCours.setAttacheDeClasse(attacheDeClasse);
            sessionCoursRepository.save(sessionCours);
        }

    }
}
