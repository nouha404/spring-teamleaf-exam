package com.nouhaTeamleaf.nouhaTeamleaf.data.services.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ModulesRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModulesRepository moduleRepository;
    @Override
    public List<Module> getModules() {
        return moduleRepository.findAllByIsActiveTrue();
    }
}
