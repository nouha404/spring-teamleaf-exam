package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface SessionCoursController {

    @GetMapping("/session")
    String listeSessionCours(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(defaultValue = "", name = "module") String module
    );

    @GetMapping("/session/professeur/validate")
    String validateSession(
            @RequestParam(name = "id") long id
    );
    @GetMapping("/session/professeur")
    String listSessionsByProfessorForCurrentMonth(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(name = "id") Long id,
            @RequestParam(value = "module", required = false) String module
    );

    @PostMapping("/session/professeur/invalidate")
    String inValidateSession(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "sessionId", required = false) Long sessionId
    );

}
