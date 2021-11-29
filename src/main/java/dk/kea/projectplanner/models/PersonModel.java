package dk.kea.projectplanner.models;

public class PersonModel {
    private long id;
    private String firstName;
    private String lastName;
    private UserModel userModel;

    public PersonModel(String firstName, String lastName, UserModel userModel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userModel = userModel;
    }

    public PersonModel(long id, String firstName, String lastName, UserModel userModel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userModel = userModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }
}
