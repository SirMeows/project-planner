/*
Author He
25.11.2021
 */

package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.PersonModel;
import dk.kea.projectplanner.models.UserModel;
import dk.kea.projectplanner.repositories.UserRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepos;

    public UserService(UserRepository userRepos) {
        this.userRepos = userRepos;
    }

    UserModel createUser(UserModel userModel, PersonModel personModel) {
        userRepos.createUser(userModel, personModel); // should this ask for personId or model?
        return userModel;
    }

    UserModel findById(long id) {
        return userRepos.findById(id);
    }

    UserModel findByUsername(String username) {
        return userRepos.findByUsername(username);
    }

    void deleteById(long id) {
        userRepos.deleteById(id);
    }

    UserModel updatePassword(UserModel userModel) {
        userRepos.updatePassword(userModel);
        return userModel;
    }

    Map<Long, UserModel> findAllUsers() {
        return ListToMapUtility.listToMapUser(userRepos.findAllUsers());
    }

    Map<Long, UserModel> findBySearchTerm(String searchTerm) {
        return ListToMapUtility.listToMapUser(userRepos.findBySearchTerm(searchTerm));
    }
}