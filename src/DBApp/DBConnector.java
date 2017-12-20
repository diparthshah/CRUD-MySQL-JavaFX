package DBApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String USERNAME="root";
    private static final String PASSWORD="lol100";
    private static final String CONN="jdbc:mysql://localhost:3306/fxdb";

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
}
