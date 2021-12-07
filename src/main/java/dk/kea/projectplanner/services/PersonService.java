package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.PersonModel;
import dk.kea.projectplanner.repositories.PersonRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonService {

    private final PersonRepository personRepos;

    public PersonService(PersonRepository personRepos) {
        this.personRepos = personRepos;
    }

    PersonModel createPerson(PersonModel personModel) {
        personRepos.createPerson(personModel);
        return personModel;
    }

    PersonModel updateFirstName(PersonModel personModel) {
        personRepos.updateFirstName(personModel);
        return personModel;
    }

    PersonModel updateLastName(PersonModel personModel) {
        personRepos.updateLastName(personModel);
        return personModel;
    }

    PersonModel findById(long id) {
        return personRepos.findById(id);
    }

    void deleteById(long id) {
        personRepos.deleteById(id);
    }

    // TODO: addUserToPerson()

    Map<Long, PersonModel> findAllPersons() {
        return ListToMapUtility.listToMapPerson(personRepos.findAllPersons());
    }









}
