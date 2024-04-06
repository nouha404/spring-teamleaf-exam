package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.configurations.FakerConfig;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EFiliere;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.ENiveau;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(4)
@RequiredArgsConstructor
//@Component
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final FiliereRepository filiereRepository;
    private final NiveauRepository niveauRepository;

    @Override
    public void run(String... args) throws Exception {
        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(libelle.getIndexEnumEtat()).orElse(null);
            for (EFiliere filiere : EFiliere.values() ){
                Filiere fl = filiereRepository.findById(filiere.getIndexEnumEtat()).orElse(null);
                if (niveau != null) {
                    for (Long i = 1L; i < 3L; i++){
                        Classe classe = new Classe();
                        classe.setLibelle(libelle.name()+filiere.name());
                        classe.setIsActive(true);
                        classe.setNiveau(niveau);
                        classe.setFiliere(fl);

                        classeRepository.save(classe);
                    }
                }

            }
        }


    }
}