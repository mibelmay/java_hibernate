package com.example.service;

import com.example.model.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static DBService UsersService = new DBService();
    static Map<String, UserProfile> loginToUserProfile = new HashMap<>(){{
        put("stas", new UserProfile("stas", "123", "stasik"));
    }};


    public static void register(String login, String password, String email) {
        loginToUserProfile.put(login, new UserProfile(login, password, email));
        UsersService.addUser(new UserProfile(login, password, email));
    }

    public static UserProfile getUserByLogin(String login) {
        return loginToUserProfile.get(login);
    }
}

