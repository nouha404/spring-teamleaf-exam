package com.nouhaTeamleaf.nouhaTeamleaf.security.repositories;


import com.nouhaTeamleaf.nouhaTeamleaf.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
