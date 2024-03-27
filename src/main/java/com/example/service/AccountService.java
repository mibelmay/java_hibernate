package com.example.service;

import com.example.model.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static final DBService UsersService = new DBService();

    public static void register(String login, String password, String email) {
        UsersService.addUser(new UserProfile(login, password, email));
    }

    public static UserProfile getUserByLogin(String login) {
        return UsersService.getUserByLogin(login);
    }
}

