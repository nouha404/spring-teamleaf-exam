package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.ClasseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;
    @Override
    public List<Classe> getClasses() {
        return classeRepository.findAllByIsActiveTrue();
    }
}
