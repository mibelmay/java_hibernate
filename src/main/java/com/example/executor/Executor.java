package com.example.executor;

import java.sql.*;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(update);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> T execQuery(String query,
                           ResultHandler<T> handler){
        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            T value = handler.handle(result);
            result.close();
            return value;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
