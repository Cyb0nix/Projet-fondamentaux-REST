package com.example.restapi.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnectionManager {
    private DataSource dataSource;

    public DbConnectionManager() throws NamingException {
        // Initialize the DataSource from JNDI on construction
        InitialContext ctx = new InitialContext();
        this.dataSource = (DataSource) ctx.lookup("jdbc/train");
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet;
        }
    }

}
