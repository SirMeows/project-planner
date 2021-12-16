/*
Author He
13.12.2021
 */

package dk.kea.projectplanner.controllers;

import dk.kea.projectplanner.models.PersonModel;
import dk.kea.projectplanner.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manage-person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ModelAttribute("person")
    public PersonModel personModel() {
        return personModel();
    }

    // create person

    // find person

    // find all

    // change first name

    // change last name

    // remove person

    // set person to inactive -> need to create bool isActive(PersonModel personModel)

    // make person a user (create login), redirect to another page, that calls UserService
}
