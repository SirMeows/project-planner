package dk.kea.projectplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index") // TODO: correct mapping
    public String index(){
        return "index";
    }

}