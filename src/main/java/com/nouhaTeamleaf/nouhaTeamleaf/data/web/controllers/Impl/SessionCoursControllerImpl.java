package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ProfesseurRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.SessionCoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.SessionCoursRequestDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class SessionCoursControllerImpl implements SessionCoursController {
    private final SessionCoursService sessionCoursService;
    private final ProfesseurRepository professeurRepository;
    private final ModuleService moduleService;
    private final ProfesseurService professeurService;
    private final CoursService coursService;
    private final SalleService salleService;
    private final ClasseService classeService;

    @Override
    public String listeSessionCours(
            Model model,
            int page, int size,
            Long professeurId,
            String module
    ) {
        Page<SessionCours> sessionCours = sessionCoursService.getSessionCours(module,professeurId,PageRequest.of(page,size));
        Page<SessionCoursResponseDto> sessionCoursDto = sessionCours.map(SessionCoursResponseDto::toDto);

        //charger les selects
        List<Module> modules = moduleService.getModules();
        Stream<ModuleSimpleResponseDto> moduleList = modules.stream().map(ModuleSimpleResponseDto::toDto);
        List<Professeur> professeurs = professeurService.getProfesseur();
        Stream<ProfesseurSimpleResponseDto> professeurList = professeurs.stream().map(ProfesseurSimpleResponseDto::toDto);


        //model.addAttribute("id",id);
        model.addAttribute("sessionsCours", sessionCoursDto.getContent());
        model.addAttribute("pages",new int[sessionCoursDto.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < sessionCoursDto.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        model.addAttribute("modules",moduleList);
        model.addAttribute("professeurs",professeurList);

        return "SessionCours/index";
    }



    @Override
    public String listSessionsByProfessorForCurrentMonth(
            Model model,
            int page, int size,
            Long id,
            String module
    ) {
        Page<SessionCours> sessions = sessionCoursService.getSessionsByProfessorForCurrentMonth(PageRequest.of(page,size),id,module);
        Page<SessionCoursResponseDto> sessionCoursDto = sessions.map(SessionCoursResponseDto::toDto);
        model.addAttribute("sessions", sessionCoursDto.getContent());
        Professeur professeur = professeurRepository.findById(id).orElseThrow();

        model.addAttribute("id",id);
        model.addAttribute("nom",professeur.getPrenom()+" "+professeur.getNom());
        model.addAttribute("pages",new int[sessionCoursDto.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < sessionCoursDto.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        return "SessionCours/sessionListProfeseur";
    }

    @Override
    public String inValidateSession(Long id,Long sessionId) {
        sessionCoursService.inValidateSessionCours(id,sessionId);
        System.out.println(id);
        return "redirect:/session?professeur?id"+id;
    }

    @Override
    public String showForm(Model model) {
        List<Cours> cours = coursService.getCours();
        Stream<CoursResponseDto> coursList =cours.stream().map(
                CoursResponseDto::toDto
        );
        List<Salle> salles = salleService.getSalles();
        Stream<SalleSimpleResponseDto> salleListe =salles.stream().map(
                SalleSimpleResponseDto::toDto
        );

        List<Module> modules = moduleService.getModules();
        Stream<ModuleSimpleResponseDto> moduleList = modules.stream().map(ModuleSimpleResponseDto::toDto);

        List<Classe> classes = classeService.getClasses(); // Obtenez la liste des classes depuis votre service
        /*Stream<ClasseSimpleResponseDto> classeList = classes.stream().map(
                ClasseSimpleResponseDto::toDto
        );*/
        //sans doublons
        Set<String> uniqueClassLabels = new HashSet<>();
        classes.forEach(classe -> uniqueClassLabels.add(classe.getLibelle()));
        List<ClasseSimpleResponseDto> uniqueClassList = uniqueClassLabels.stream()
                .map(libelle -> new ClasseSimpleResponseDto(null, libelle))
                .collect(Collectors.toList());

        SessionCoursRequestDto sessionCoursRequestDto = SessionCoursRequestDto.builder().build();

        model.addAttribute("sessionCoursForm",sessionCoursRequestDto);
        model.addAttribute("coursSelectForm",coursList);
        model.addAttribute("salleSelectForm", salleListe);
        model.addAttribute("classeelectForm", uniqueClassList);
        return "SessionCours/form-add-sc";
    }

    @Override
    public String saveTypeSession(
            Model model,
            String typeSession
    ) {
        if ("PRESENTIEL".equals(typeSession)) {
            model.addAttribute("showSalleSelect", true);
            System.out.println("YES");
        } else {
            model.addAttribute("showSalleSelect", false);
        }

        return showForm(model);
    }

    @Override
    public String saveSessionCours(Model model, SessionCoursRequestDto sessionCoursRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
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

            redirectAttributes.addFlashAttribute("cours", sessionCoursRequestDto.getCours());
            redirectAttributes.addFlashAttribute("etatSession", sessionCoursRequestDto.getEtatSession());
            redirectAttributes.addFlashAttribute("typeSession", sessionCoursRequestDto.getTypeSession());
            return "redirect:/sessionCoursForm";
        } else {
            sessionCoursService.addSessionCours(sessionCoursRequestDto);
        }
        return "redirect:/cours";
    }

    @Override
    public String validateSession(Long id,Long sessionId) {
        sessionCoursService.validateSessionCours(id,sessionId);
        return "redirect:/session?professeur?id=" + id;
    }
}
