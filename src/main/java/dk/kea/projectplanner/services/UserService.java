package dk.kea.projectplanner.services;

import dk.kea.projectplanner.models.UserModel;
import dk.kea.projectplanner.repositories.UserRepository;
import dk.kea.projectplanner.util.ListToMapUtility;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepos;

    public UserService(UserRepository userRepos) {
        this.userRepos = userRepos;
    }

    UserModel createUser(UserModel userModel) {
        userRepos.createUser(userModel);
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
