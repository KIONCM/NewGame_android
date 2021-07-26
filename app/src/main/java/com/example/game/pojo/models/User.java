package com.example.game.pojo.models;

public class User implements IUser {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String roles;
    private String username;
    private String pofilePicture;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPofilePicture() {
        return pofilePicture;
    }

    public void setPofilePicture(String pofilePicture) {
        this.pofilePicture = pofilePicture;
    }




    public User(String firstName, String lastName, String password, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.username = userName;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Class getUserType() {
        return null;
    }

    @Override
    public String getUserRole() {
        return null;
    }
}
