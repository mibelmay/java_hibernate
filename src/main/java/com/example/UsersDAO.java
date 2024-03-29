package com.example;

import com.example.executor.Executor;
import com.example.model.UserProfile;
import org.postgresql.core.ResultHandler;

import java.sql.*;

public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public void insertUser(String login, String password, String email) throws SQLException{
        executor.execUpdate(
                "insert into users (login, pass, email) values (?, ?, ?)",
                statement -> {
                    statement.setString(1, login);
                    statement.setString(2, password);
                    statement.setString(3, email);
                });
    }

    public UserProfile getUserByLogin(String login) throws SQLException {
        return executor.execQuery("select * from users where login=?",
                (statement) -> statement.setString(1, login),
                (resultSet) -> {
            resultSet.next();
            return new UserProfile(
                    resultSet.getString("login"),
                    resultSet.getString("pass"),
                    resultSet.getString("email"));
                });
    }
}

