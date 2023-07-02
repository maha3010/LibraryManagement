package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableModule {
    public static void main(String[] args) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute the drop table query
            String sql = "DROP TABLE IF EXISTS books";
            boolean success = statement.execute(sql);
            if (success) {
                System.out.println("The table was dropped successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

