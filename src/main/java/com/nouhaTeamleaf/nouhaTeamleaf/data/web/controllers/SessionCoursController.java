package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers;


import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.CoursRequestDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.SessionCoursRequestDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface SessionCoursController {

    @GetMapping("/session")
    String listeSessionCours(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(name = "professeurId",required = false) Long professeurId,
            @RequestParam(defaultValue = "", name = "module") String module
    );
    @GetMapping("/session/professeur")
    String listSessionsByProfessorForCurrentMonth(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(name = "id") Long id,
            @RequestParam(value = "module", required = false) String module
    );

    @PostMapping("/session/validate")
    String validateSession(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "sessionId", required = false) Long sessionId
    );



    @PostMapping("/session/professeur/invalidate")
    String inValidateSession(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "sessionId", required = false) Long sessionId
    );

    @GetMapping("/sessionCoursForm")
    String showForm(Model model);

    @PostMapping("/save-type-session")
    String saveTypeSession(
            Model model,
            @RequestParam("typeSession")  String typeSession
    );

    @PostMapping("/save-sessionCours")
    String saveSessionCours(
            Model model,
            SessionCoursRequestDto sessionCoursRequestDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    );



}
