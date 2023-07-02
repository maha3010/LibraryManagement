package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertModule {
	public static void main(String[] args) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","")) {
            // Prepare the insert statement
            String sql = "INSERT INTO books (book_id, title, author, publication_year) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Get user input for book details
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author name: ");
            String author = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int publicationYear = scanner.nextInt();
            
            // Set the parameter values
            statement.setInt(1, bookId);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setInt(4, publicationYear);
            
            // Execute the insert statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
