package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ProfesseurRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.*;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.SessionCoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.request.SessionCoursRequestDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String showForm(Model model,Long id) {
        //List<Cours> cours = coursService.getCours();

        Long coursId = (Long) model.getAttribute("coursId");


        List<Salle> salles = salleService.getSalles();
        List<Module> modules = moduleService.getModules();
        List<Classe> classes = classeService.getClasses(); // Obtenez la liste des classes depuis votre service

        Stream<SalleSimpleResponseDto> salleListe =salles.stream().map(SalleSimpleResponseDto::toDto);
        Stream<ModuleSimpleResponseDto> moduleList = modules.stream().map(ModuleSimpleResponseDto::toDto);

        //sans doublons
        Set<String> uniqueClassLabels = new HashSet<>();
        classes.forEach(classe -> uniqueClassLabels.add(classe.getLibelle()));
        List<ClasseSimpleResponseDto> uniqueClassList = uniqueClassLabels.stream()
                .map(libelle -> new ClasseSimpleResponseDto(null, libelle))
                .collect(Collectors.toList());

        SessionCoursRequestDto sessionCoursRequestDto = SessionCoursRequestDto.builder().build();



        model.addAttribute("sessionCoursForm",sessionCoursRequestDto);
        //model.addAttribute("coursSelectForm",coursList);
        model.addAttribute("salleSelectForm", salleListe);
        model.addAttribute("classeelectForm", uniqueClassList);
        model.addAttribute("coursId", id);
        return "SessionCours/form-add-sc";
    }



    @Override
    public String saveTypeSession(
            Model model,
            String typeSession,
            Long id
    ) {
        if ("PRESENTIEL".equals(typeSession)) {
            model.addAttribute("showSalleSelect", true);
            System.out.println("YES");
        } else {
            model.addAttribute("showSalleSelect", false);
        }


        return showForm(model,id);
        //return "forward:/save-sessionCours/nouveau/" + id;
        //return "redirect:/sessionCoursForm/nouveau/" + id;
    }

    @Override
    public String saveSessionCours(Long id,
                                   @Valid SessionCoursRequestDto sessionCoursRequestDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes
    ) {
        System.out.println("ID reçu : " + id);
        System.out.println("SessionCoursRequestDto reçu : " + sessionCoursRequestDto);


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

            redirectAttributes.addFlashAttribute("date", sessionCoursRequestDto.getDate());
            redirectAttributes.addFlashAttribute("cours", sessionCoursRequestDto.getCours());
            redirectAttributes.addFlashAttribute("heureDebut", sessionCoursRequestDto.getHeureDebut());
            redirectAttributes.addFlashAttribute("heureFin", sessionCoursRequestDto.getHeureFin());
            redirectAttributes.addFlashAttribute("salle", sessionCoursRequestDto.getSalle());
            redirectAttributes.addFlashAttribute("classe", sessionCoursRequestDto.getSessionCoursClasses());

            System.out.println(sessionCoursRequestDto);
            return "redirect:/sessionCoursForm/nouveau/"+id;

            } else {
                System.out.println("Pas d'erreurs de validation.");
                sessionCoursService.addSessionCours(sessionCoursRequestDto,id);
                return "redirect:/cours";
            }

    }


    @Override
    public String validateSession(Long id,Long sessionId) {
        sessionCoursService.validateSessionCours(id,sessionId);
        return "redirect:/session?professeur?id=" + id;
    }
}
