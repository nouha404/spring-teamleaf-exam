package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Etudiant;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.InscriptionRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.CoursService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.CoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.CoursResponseDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.EtudiantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {
    private final CoursService coursService;
    private final SessionCoursService sessionCoursService;
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
    public String listeEtudiant(
            Model model,
            Long id, Long moduleId,int page,
            int size
    ) {
        Page<Etudiant> etudiants = sessionCoursService.getEtudiantByModuleAndCours(id,moduleId, PageRequest.of(page, size));
        //Page<Etudiant> etudiants = sessionCoursService.getEtudiantByCours(id, PageRequest.of(page, size));
        Page<EtudiantResponseDto> etudiantDto = etudiants.map(EtudiantResponseDto::toDto);

        model.addAttribute("etudiants", etudiants.getContent());
        model.addAttribute("id",id);
        model.addAttribute("pages",new int[etudiantDto.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < etudiantDto.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        return "CoursPlanifier/etudiants";
    }
}
