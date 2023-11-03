package org.example;

public class User {

    private String firstname;

    private String lastname;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String setFirstname(String firstname){
        this.firstname = firstname;
        return firstname;
    }
    public String setLastname(String lastname){
        this.lastname = lastname;
        return lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
