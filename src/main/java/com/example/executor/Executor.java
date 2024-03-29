package com.example.executor;

import java.sql.*;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update, StatementPreparer preparer) {
        try (var stmt = connection.prepareStatement(update)) {
            preparer.prepare(stmt);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> T execQuery(String query, StatementPreparer preparer,
                           ResultHandler<T> handler){
        try(var stmt = connection.prepareStatement(query)) {
            preparer.prepare(stmt);
            stmt.executeQuery();
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
