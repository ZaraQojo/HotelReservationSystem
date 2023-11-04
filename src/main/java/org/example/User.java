package org.example;

public class User {
    private String username;
    private String password;


    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setRole(String role) {

        this.role = role;
    }

    private String role;


    public User() {
        this("", "", "");
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public String getRole() {

        return role;
    }
}