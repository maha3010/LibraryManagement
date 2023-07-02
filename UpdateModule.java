package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateModule {
    public static void main(String[] args) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Get user input for the update query
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the UPDATE query: ");
            String updateQuery = scanner.nextLine();
            
            // Execute the update query
            int rowsUpdated = statement.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("The update was successful. Rows updated: " + rowsUpdated);
            } else {
                System.out.println("No rows were updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
