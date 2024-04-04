package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

public interface SessionCoursController {

    @GetMapping("/session")
    String listeSessionCours(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(defaultValue = "", name = "module") String module
    );
}
