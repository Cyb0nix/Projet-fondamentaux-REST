package com.example.restapi.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DbConnectionManager {
    private DataSource dataSource;

    public DbConnectionManager() throws NamingException {
        // Initialize the DataSource from JNDI on construction
        InitialContext ctx = new InitialContext();
        this.dataSource = (DataSource) ctx.lookup("jdbc/train");
    }

    public Statement createStatement(String sql) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
             Statement statement = connection.createStatement();
             return statement;
        }
    }

}
