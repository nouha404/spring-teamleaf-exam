package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Niveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Semestre;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.NiveauRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@RequiredArgsConstructor
//@Component
public class SemestreFixtures implements CommandLineRunner {
    private final SemestreRepository semestreRepository;
    private final NiveauRepository niveauRepository;
    @Override
    public void run(String... args) throws Exception {

        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(libelle.getIndexEnumEtat()).orElse(null);
            for (int i = 1; i <= 2; i++) {
                Semestre semestre = new Semestre();
                semestre.setLibelle("Semestre " + i);
                semestre.setNiveau(niveau);
                semestre.setIsActive(true);
                semestreRepository.save(semestre);
            }
        }
    }
}