package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Filiere;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EFiliere;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@RequiredArgsConstructor
//@Component
public class FiliereFixtures implements CommandLineRunner {
    private final FiliereRepository filiereRepository;
    @Override
    public void run(String... args) throws Exception {
        for (EFiliere libelle : EFiliere.values()){
            Filiere filiere = new Filiere();
            filiere.setIsActive(true);
            filiere.setEFiliere(EFiliere.valueOf(libelle.name()));
            filiereRepository.save(filiere);
        }

    }
}
