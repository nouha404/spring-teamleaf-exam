package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(16)
@RequiredArgsConstructor
//@Component
public class SessionCoursEtudiantFixtures implements CommandLineRunner {
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    private final SessionCoursEtudiantRepository sessionCoursEtudiantRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        List<SessionCours> sessionCoursList = sessionCoursRepository.findAll();

        for (SessionCours sessionCours : sessionCoursList) {
            for (Etudiant etudiant : etudiantList) {
                SessionCoursEtudiant sessionCoursEtudiant = new SessionCoursEtudiant();
                sessionCoursEtudiant.setIsActive(true);
                sessionCoursEtudiant.setEtudiant(etudiant);
                sessionCoursEtudiant.setSessionCours(sessionCours);

                sessionCoursEtudiantRepository.save(sessionCoursEtudiant);
            }
        }

    }
}
