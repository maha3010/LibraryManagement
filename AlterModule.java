package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlterModule {
    public static void main(String[] args) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Get user input for the alteration query
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the ALTER TABLE query: ");
            String alterQuery = scanner.nextLine();
            
            // Execute the ALTER TABLE query
            boolean success = statement.execute(alterQuery);
            if (success) {
                System.out.println("The table was altered successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
