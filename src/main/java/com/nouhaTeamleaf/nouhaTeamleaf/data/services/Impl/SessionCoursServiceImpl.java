package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatSession;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ProfesseurRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionCoursRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public Page<SessionCours> getSessionCours(Pageable page, String module) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByModule(module, page);
        } else {
            return sessionCoursRepository.findAllByActiveTrueAndEtatSessionIsTrue(page);
        }
    }

    @Override
    public void validateSessionCours(Long id) {
        SessionCours sessionCours = sessionCoursRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Session de cours non trouvée avec l'ID : " + id));
        sessionCours.setEtatSession(EtatSession.VALIDER);
        sessionCoursRepository.save(sessionCours);
    }

    @Override
    public void inValidateSessionCours(Long id,Long sessionId) {
        SessionCours sessionCours = sessionCoursRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session de cours non trouvée avec l'ID : " + sessionId));

        sessionCours.setEtatSession(EtatSession.INVALIDER);
        sessionCours.setActive(false);
        sessionCoursRepository.save(sessionCours);
    }

    @Override
    public Page<SessionCours> getSessionsByProfessorForCurrentMonth(Pageable pageable,Long professorId,String module) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByProfessorAndModule(pageable, professorId, module);
        } else {
            return sessionCoursRepository.findByProfessorForCurrentMonth(pageable,professorId);
        }


    }
}
