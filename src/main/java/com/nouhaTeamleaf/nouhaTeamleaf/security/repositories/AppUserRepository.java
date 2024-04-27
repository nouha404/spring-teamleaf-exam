package com.nouhaTeamleaf.nouhaTeamleaf.security.repositories;


import com.nouhaTeamleaf.nouhaTeamleaf.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
