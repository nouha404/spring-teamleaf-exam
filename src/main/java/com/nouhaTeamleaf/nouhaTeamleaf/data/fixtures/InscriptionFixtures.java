package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.AnneeScolaire;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Inscription;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.AnneeScolaireRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.EtudiantRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(7)
@RequiredArgsConstructor
//@Component
public class InscriptionFixtures implements CommandLineRunner {
    private final InscriptionRepository inscriptionRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;

    @Override
    public void run(String... args) throws Exception {
        AnneeScolaire anneeScolaire = anneeScolaireRepository.findByIsActiveTrue();
        List<Classe> classeList = classeRepository.findAll();
        for (long i = 1L; i < 5L; i++){
            Etudiant etudiant = etudiantRepository.findById(i).orElse(null);
            Inscription inscription = new Inscription();
            inscription.setIsActive(true);
            inscription.setEtudiant(etudiant);
            inscription.setAnneeScolaire(anneeScolaire);
            inscription.setClasse(classeList.get((int) i % classeList.size()));
            inscriptionRepository.save(inscription);
        }
    }
}
