package com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.Impl;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Professeur;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.SessionCours;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ProfesseurRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.services.SessionCoursService;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.controllers.SessionCoursController;
import com.nouhaTeamleaf.nouhaTeamleaf.data.web.dto.response.SessionCoursResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SessionCoursControllerImpl implements SessionCoursController {
    private final SessionCoursService sessionCoursService;
    private final ProfesseurRepository professeurRepository;

    @Override
    public String listeSessionCours(
            Model model,
            int page, int size,
            String module
    ) {
        Page<SessionCours> sessionCours = sessionCoursService.getSessionCours(PageRequest.of(page,size),module);
        Page<SessionCoursResponseDto> sessionCoursDto = sessionCours.map(SessionCoursResponseDto::toDto);
        model.addAttribute("sessionsCours", sessionCoursDto.getContent());
        //model.addAttribute("module", module);
        model.addAttribute("pages",new int[sessionCoursDto.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("nextPage", page < sessionCoursDto.getTotalPages() - 1 ? page+1:page);
        model.addAttribute("PreviousPage", page > 0 ? page-1:page);

        return "SessionCours/index";
    }
}
