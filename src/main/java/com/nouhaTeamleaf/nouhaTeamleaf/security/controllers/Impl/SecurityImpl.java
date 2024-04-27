package com.nouhaTeamleaf.nouhaTeamleaf.security.controllers.Impl;


import com.nouhaTeamleaf.nouhaTeamleaf.security.controllers.Security;
import com.nouhaTeamleaf.nouhaTeamleaf.security.data.entities.AppUser;
import com.nouhaTeamleaf.nouhaTeamleaf.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    private final SecurityService securityService;

    @Override
    public String test() {
        return "login";
    }

    @Override
    public String login(@AuthenticationPrincipal UserDetails user) {
        System.out.println(user.getUsername() + " est connecté !");
        // anyMatch dès qu'il trouve un critere valid …
        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("RP") == 0) ){
            return "redirect:/session";
        }

        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("PROFESSEUR") == 0) ){
            //recuperer le user
            AppUser usr = securityService.getUser(user.getUsername());
            return "redirect:/session/professeur?id="+ usr.getId();

        }
        return "redirect:/login";
    }


}
