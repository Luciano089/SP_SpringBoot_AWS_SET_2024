package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }

        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();

            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("C:\\Compass_Uol_Trilha\\SP_SpringBoot_AWS_SET_2024\\Semana-03\\Projeto_JDBC\\db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new dbException(e.getMessage());
        }
    }

    public static void closeStatment(Statement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }
}
