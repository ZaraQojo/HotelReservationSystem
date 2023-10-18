package org.example;

public class User {
    private static int id = 0; // id counter
    private int userID; // user id
    private String userName;
    private String password;
    private String name;


    public User(String userName, String password) {
        id++ ;
        this.userID= id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
