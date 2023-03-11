package com.example.demo.session;

public class UserRepository {

    public String name;
    public String password;

    public UserRepository(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static UserRepository userData(String name, String password) throws RuntimeException {
        return new UserRepository(name, password);
    }
}
