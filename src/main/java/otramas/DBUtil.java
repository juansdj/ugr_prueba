package otramas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String USERNAME = "juanuser";
    private static final String PASSWORD = "juan1989";
    private static final String URL = "jdbc:mariadb://localhost:3306/ugr";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
