package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursClasse;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(15) //15
@RequiredArgsConstructor
//@Component
public class SessionCoursClasseFixtures implements CommandLineRunner {
    private final SessionCoursClasseRepository sessionCoursClasseRepository;
    private final SessionCoursRepository sessionCoursRepository;
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Classe> classeList = classeRepository.findAll();
        List<SessionCours> sessionCoursList = sessionCoursRepository.findAll();
        for (SessionCours sessionCours : sessionCoursList) {
            for (Classe classe : classeList) {
                SessionCoursClasse sessionCoursClasse = new SessionCoursClasse();
                sessionCoursClasse.setIsActive(true);
                sessionCoursClasse.setSessionCours(sessionCours);
                sessionCoursClasse.setClasse(classe);
                sessionCoursClasseRepository.save(sessionCoursClasse);
            }
        }

    }
}
