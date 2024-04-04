package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.enums.EtatCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.CoursService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.CoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.CoursResponseDto;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.SessionCoursResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class CoursControllerImpl implements CoursController {
    private final CoursService coursService;
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
}
