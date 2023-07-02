package System;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("Library Management System");
            System.out.println("1. Insert a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Update book details");
            System.out.println("4. Alter table");
            System.out.println("5. Drop table");
            System.out.println("6. Drop database");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Process the user's choice
            switch (choice) {
                case 1:
                    InsertModule.main(args);
                    break;
                case 2:
                    DeleteModule.main(args);
                    break;
                case 3:
                    UpdateModule.main(args);
                    break;
                case 4:
                    AlterModule.main(args);
                    break;
                case 5:
                    DropTableModule.main(args);
                    break;
                case 6:
                    DropDatabaseModule.main(args);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

