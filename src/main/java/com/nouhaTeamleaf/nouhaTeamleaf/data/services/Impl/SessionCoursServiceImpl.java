package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.EtudiantRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionCoursServiceImpl implements SessionCoursService {
    private final SessionCoursRepository sessionCoursRepository;
    private final EtudiantRepository etudiantRepository;

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
    public Page<Etudiant> getEtudiantByModuleAndCours(Long sessionId, Long moduleId, Pageable page) {
        return sessionCoursRepository.findEtudiantByModule(sessionId,moduleId,page);
    }


}
