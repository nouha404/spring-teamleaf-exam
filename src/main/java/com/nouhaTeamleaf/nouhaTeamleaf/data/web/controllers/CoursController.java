package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers;

import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CoursController {
    @GetMapping("/cours")
    String listeCours(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(required = false, name = "etat") String etat
    );

    @GetMapping("/etudiants")
    String listeEtudiant(
            Model model,
            @RequestParam("coursId") Long coursId,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size
    );
}
