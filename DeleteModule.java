package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteModule {
    public static void main(String[] args) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Prepare the delete statement
            String sql = "DELETE FROM books WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Get user input for book ID to delete
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter book ID to delete: ");
            int bookId = scanner.nextInt();
            
            // Set the parameter value
            statement.setInt(1, bookId);
            
            // Execute the delete statement
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The book was deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
