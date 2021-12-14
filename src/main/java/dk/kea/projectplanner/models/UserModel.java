package dk.kea.projectplanner.models;

import dk.kea.projectplanner.validation.ValidPassword;

public class UserModel extends PersonModel {
    private long id;

    private String userName;

    @ValidPassword
    private String password;

    private PersonModel personModel;

    public UserModel(String userName, String password, PersonModel personModel) {
        this.userName = userName;
        this.password = password;
        this.personModel = personModel;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }
}
