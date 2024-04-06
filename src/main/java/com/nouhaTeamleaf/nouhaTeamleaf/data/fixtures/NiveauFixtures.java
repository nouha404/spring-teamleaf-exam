package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@RequiredArgsConstructor
//@Component
public class NiveauFixtures implements CommandLineRunner {
    private final NiveauRepository niveauRepository;
    @Override
    public void run(String... args) throws Exception {
        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = new Niveau();
            niveau.setIsActive(true);
            niveau.setLibelle(ENiveau.valueOf(libelle.name()));
            niveauRepository.save(niveau);
        }
    }
}