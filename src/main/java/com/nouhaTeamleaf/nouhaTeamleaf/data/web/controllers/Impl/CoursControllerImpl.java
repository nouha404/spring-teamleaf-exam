package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ModulesRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.CoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.CoursRequestDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.*;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {
    private final CoursService coursService;
    private final ModuleService moduleService;
    private final ModulesRepository modulesRepository;
    private final ProfesseurService professeurService;
    private final SemestreService semestreService;
    @Override
    public String listeCours(
            Model model, int page,
            int size,
            String etat
    ) {
        Page<Cours> cours = coursService.getCours(etat,PageRequest.of(page,size));
        Page<CoursResponseDto> coursDto = cours.map(CoursResponseDto::toDto);

        model.addAttribute("coursPlanifier", coursDto.getContent());

        model.addAttribute("pages",new int[coursDto.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < coursDto.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        return "CoursPlanifier/index";
    }

    @Override
    public String saveCours(Model model, CoursRequestDto coursRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            //maintenant parcourir et les transformer en map
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(
                    fieldError.getField(), fieldError.getDefaultMessage())
            );
            //mettre les erreurs dans la view
            redirectAttributes.addFlashAttribute("mode", "error");
            redirectAttributes.addFlashAttribute("errors", errors);

            redirectAttributes.addFlashAttribute("semestre", coursRequestDto.getSemestre());
            redirectAttributes.addFlashAttribute("module", coursRequestDto.getModule());
            redirectAttributes.addFlashAttribute("nombreHeureGlobal", coursRequestDto.getNbreHeureGlobal());
            redirectAttributes.addFlashAttribute("professeur", coursRequestDto.getProfesseur());
            return "redirect:/show-form/";
        } else {
            coursService.addCours(coursRequestDto);
        }
        return "redirect:/cours";
    }

    @Override
    public String showCoursForm(Model model) {
        List<Module> modules = moduleService.getModules();
        Stream<ModuleSimpleResponseDto> moduleList =modules.stream().map(
                ModuleSimpleResponseDto::toDto
        );

        List<Professeur> professeurs = professeurService.getProfesseur();
        Stream<ProfesseurSimpleResponseDto> professeurList = professeurs.stream().map(
                ProfesseurSimpleResponseDto::toDto
        );

        List<Semestre> semestres = semestreService.getSemestre();
        Stream<SemestreSimpleResponseDto> semestreList = semestres.stream().map(
                SemestreSimpleResponseDto::toDto
        );
        CoursRequestDto coursRequestDto = CoursRequestDto.builder().build();
        model.addAttribute("coursForm",coursRequestDto);
        model.addAttribute("moduleSelectForm",moduleList);
        model.addAttribute("semestreSelectForm",semestreList);
        model.addAttribute("professeurSelectForm",professeurList);



        return "CoursPlanifier/form-add-cours";
    }
}
