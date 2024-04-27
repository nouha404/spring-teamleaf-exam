package com.nouhaTeamleaf.nouhaTeamleaf.security.data.fixtures;


import com.nouhaTeamleaf.nouhaTeamleaf.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
@Order(1)
public class AppRoleFixtures implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {

        securityService.saveRole("RP");
        securityService.saveRole("ATTACHE");
        securityService.saveRole("PROFESSEUR");
        securityService.saveRole("ETUDIANT");
    }
}
