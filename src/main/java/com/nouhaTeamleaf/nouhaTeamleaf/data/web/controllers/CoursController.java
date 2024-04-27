package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers;

import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.CoursRequestDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface CoursController {
    @GetMapping("/cours")
    String listeCours(
            Model model,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "5", name = "size") int size,
            @RequestParam(required = false, name = "etat") String etat
    );

    @GetMapping("/cours/details/{id}")
    String detailCours(
            Model model,
            @PathVariable Long id
    );


    @PostMapping("/save-cours")
    String saveCours(
            CoursRequestDto coursRequestDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    );

    @GetMapping("/show-form")
    String showCoursForm(Model model);
}
