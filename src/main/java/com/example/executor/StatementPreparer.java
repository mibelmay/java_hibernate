package com.example.executor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementPreparer {
    void prepare(PreparedStatement statement) throws SQLException;
}
