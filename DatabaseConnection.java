package assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		// Initialize all the information regarding
        // Database Connection
        String dbURL = "jdbc:mysql://localhost:3306/trucktracker";
        String dbUsername = "root";
        String dbPassword = "Success@2022";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        System.out.println("MySQL connected Successfully");
        
        
        
        return con;
	}

}
