package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
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
    @Override
    public Page<SessionCours> getSessionCours(Pageable page, String module) {
        if (module != null && !module.isEmpty()) {
            return sessionCoursRepository.findByModule(module, page);
        } else {
            return sessionCoursRepository.findAllByActiveTrue(page);
        }
    }
}
