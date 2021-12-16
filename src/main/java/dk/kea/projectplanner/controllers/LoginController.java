/*
Author He
13.12.2021
 */

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
}
