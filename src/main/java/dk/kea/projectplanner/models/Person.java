package dk.kea.projectplanner.models;

public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private User user;

    public Person(String firstName, String lastName, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
    }

    public Person(long id, String firstName, String lastName, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
