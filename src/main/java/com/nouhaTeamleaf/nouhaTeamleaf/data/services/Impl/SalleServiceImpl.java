package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Salle;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SalleRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;
    @Override
    public List<Salle> getSalles() {
        return salleRepository.findAllByIsActiveTrue();
    }
}
