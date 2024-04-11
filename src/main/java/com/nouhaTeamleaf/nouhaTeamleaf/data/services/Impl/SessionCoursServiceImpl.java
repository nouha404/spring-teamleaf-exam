package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EEtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;
    private final SessionCoursEtudiantRepository sessionCoursEtudiantRepository;
    private final CoursRepository coursRepository;

    @Override
    public Page<SessionCours> getSessionCours(String module,Pageable page) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByModule(module,page);
        } else {
            return sessionCoursRepository.findAllByIsActiveTrueAndEtatSessionIsTrue(page);
        }
    }

    @Override
    public Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable, Long professorId, String module) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByProfessorAndModule(pageable, professorId, module);
        } else {
            return sessionCoursRepository.findByProfessorForCurrentMonth(pageable,professorId);
        }
    }

    @Override
    public Page<Etudiant> getEtudiantByCours(Long sessionId, Pageable page) {
        return sessionCoursRepository.findByEtudiant(sessionId,page);
    }

    @Override
    public void inValidateSessionCours(Long id, Long sessionId) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session de cours non trouvée avec l'ID : " + sessionId));

        sessionCours.setEtatSession(EEtatSession.INVALIDER);
        sessionCours.setIsActive(true);

        sessionCoursRepository.save(sessionCours);
    }

    @Override
    public void validateSessionCours(Long id, Long sessionId) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session de cours non trouvée avec l'ID : " + sessionId));
        sessionCours.setEtatSession(EEtatSession.VALIDER);

        //les heures
        LocalTime heureDebut = sessionCours.getHeureDebut();
        LocalTime heureFin = sessionCours.getHeureFin();
        long nombreHeurePlanifier = calculateHeurePlanifier(heureDebut, heureFin);
        sessionCours.setNombreHeurePlanifier(nombreHeurePlanifier);

        Cours cours = sessionCours.getCours();
        long heureGlobal = cours.getNbreHeureGlobal();
        heureGlobal -= nombreHeurePlanifier;
        cours.setNbreHeureGlobal(heureGlobal);
        sessionCours.setIsActive(false);

        coursRepository.save(cours);
        sessionCoursRepository.save(sessionCours);

    }


    private long calculateHeurePlanifier(LocalTime heureDebut, LocalTime heureFin) {
        return heureFin.getHour() - heureDebut.getHour();
    }



    @Override
    public Page<SessionCoursEtudiant> getEtudiantBySessionCours(Long sessionId, Pageable pageable) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId).orElse(null);
        System.out.println(sessionCours);
        return sessionCoursEtudiantRepository.findBySessionCours(sessionCours,pageable);
    }

}
