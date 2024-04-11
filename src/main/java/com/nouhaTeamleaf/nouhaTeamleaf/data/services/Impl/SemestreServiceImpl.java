package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SemestreRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SemestreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;
    @Override
    public List<Semestre> getSemestre() {
        return semestreRepository.findAllByIsActiveTrue();
    }
}
