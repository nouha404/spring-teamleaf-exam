package com.nouhaTeamleaf.nouhaTeamleaf.security.services;


import com.nouhaTeamleaf.nouhaTeamleaf.security.data.entities.AppRole;
import com.nouhaTeamleaf.nouhaTeamleaf.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUser(String username);
    AppUser saveUser(String username, String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);

}
