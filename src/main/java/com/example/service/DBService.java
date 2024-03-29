package com.example.service;

import com.example.UsersDAO;
import com.example.model.UserProfile;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static final Connection connection = getConnection();

    public static void addUser(UserProfile user) {
        try {
            new UsersDAO(connection).insertUser(user.getLogin(), user.getPassword(), user.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserProfile getUserByLogin(String login) {
        try {
            return new UsersDAO(connection).getUserByLogin(login);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/java_server";
            String user = "postgres";
            String pass = "mamacitachitagrita";
            return DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
