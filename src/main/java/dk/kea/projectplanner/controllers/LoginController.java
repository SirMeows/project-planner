package dk.kea.projectplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginFormError(Model model){
        model.addAttribute("error",true);
        return "login";
    }

/*  How does this part work?
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        return userDetails.getPassword();
    }*/
}
