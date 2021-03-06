package ru.kpfu.itis.garipov.helper;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionHelper {

    public static final Logger LOGGER = LoggerFactory.getLogger(PostgresConnectionHelper.class);

    private static Connection connection;
    private static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/site_architecture_houses";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgresqlgaroriz2002xD";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.error("Failed connect to db", e);
            }
        }
        return connection;
    }
}
