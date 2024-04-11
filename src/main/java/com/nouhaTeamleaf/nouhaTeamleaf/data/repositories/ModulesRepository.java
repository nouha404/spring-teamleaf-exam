package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModulesRepository extends JpaRepository<Module,Long> {
    List<Module> findAllByIsActiveTrue();
}
