package dk.kea.projectplanner.models;

import dk.kea.projectplanner.validation.ValidPassword;

public class UserModel {
    private long id;

    //TODO: Find Maven dependency and Add @NotNull
    //TODO: Create annotation to prevent creation of duplicate username (has to check db)
    private String userName;

    @ValidPassword
    private String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
}
