package com.example;

import com.example.executor.Executor;

import java.sql.*;

public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public void insertUser(String login, String password, String email) throws  SQLException{
        executor.execUpdate("insert into users (login, pass, email) values ('" + login +"', '"+password+"', '"+email+"')");
    }
}
