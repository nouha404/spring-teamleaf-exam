package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCoursClasse;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SessionCoursClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SessionCoursClasseServiceImpl implements SessionCoursClasseService {
    private final SessionCoursClasseRepository sessionCoursClasseRepository;
    @Override
    public List<SessionCoursClasse> getAllSessionCoursClasses() {
        return sessionCoursClasseRepository.findAllByIsActiveTrue();
    }
}
