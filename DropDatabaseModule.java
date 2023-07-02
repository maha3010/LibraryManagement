package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabaseModule {
    public static void main(String[] args) {
        // Connect to the database server
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute the drop database query
            String sql = "DROP DATABASE IF EXISTS library";
            boolean success = statement.execute(sql);
            if (success) {
                System.out.println("The database was dropped successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
