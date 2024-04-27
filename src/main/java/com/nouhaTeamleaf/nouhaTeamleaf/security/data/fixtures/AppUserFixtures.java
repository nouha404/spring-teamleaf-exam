package com.nouhaTeamleaf.nouhaTeamleaf.security.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.security.services.SecurityService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@RequiredArgsConstructor
@Order(2)
//@DependsOn("appRoleFixtures")
public class AppUserFixtures implements CommandLineRunner {
    private final SecurityService securityService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        securityService.saveUser("professeur","nouha12b");
        securityService.addRoleToUser("professeur","PROFESSEUR");

        securityService.saveUser("attache","nouha12b");
        securityService.addRoleToUser("attache","ATTACHE");

        securityService.saveUser("etudiant","nouha12b");
        securityService.addRoleToUser("etudiant","ETUDIANT");

        /*securityService.saveUser("prof","nouha12b");
        securityService.saveUser("etudiant","nouha12b");
        securityService.addRoleToUser("attache","ATTACHE");

        securityService.addRoleToUser("nouha","RP");
        securityService.addRoleToUser("prof","PROFESSEUR");
        securityService.addRoleToUser("etudiant","ETUDIANT");
        securityService.addRoleToUser("attache","ATTACHE");*/
    }
}
