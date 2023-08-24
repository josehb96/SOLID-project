import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        LibraryData libraryData = new LibraryData();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Welcome to the Library");
            System.out.println("1. Book Management");
            System.out.println("2. User Management");
            System.out.println("3. Loan Management");
            System.out.println("4. Report Generation");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Book Management Menu
                    bookManagementMenu(libraryData, scanner);
                    break;
                case 2:
                    // User Management Menu
                    userManagementMenu(libraryData, scanner);
                    break;
                case 3:
                    // Loan Management Menu
                    loanManagementMenu(libraryData, scanner);
                    break;
                case 4:
                    // Report Generation Menu
                    reportGenerationMenu(libraryData, scanner);
                    break;
                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void bookManagementMenu(LibraryData libraryData, Scanner scanner) {

        int choice;

        // Implement your book management functionality here
        System.out.println("Book Management Menu");
        System.out.println("1. Add new book");
        System.out.println("2. Remove book");
        System.out.println("3. Update book details");

        choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                addNewBook(libraryData, scanner);
                break;
            case 2:
                removeBook(libraryData, scanner);
                break;
            case 3:
                updateBook(libraryData, scanner);
                break;
            case 0:
                System.out.println("Returning to the main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

    }

    public static void userManagementMenu(LibraryData libraryData, Scanner scanner) {
        // Implement your user management functionality here
        System.out.println("User Management Menu");
        System.out.println("1. Register new user");
        System.out.println("2. Update user information");
        System.out.println("3. Deactivate user account");
        // Add more options as needed
    }

    public static void loanManagementMenu(LibraryData libraryData, Scanner scanner) {
        // Implement your loan management functionality here
        System.out.println("Loan Management Menu");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Calculate fines");
        // Add more options as needed
    }

    public static void reportGenerationMenu(LibraryData libraryData, Scanner scanner) {
        // Implement your report generation functionality here
        System.out.println("Report Generation Menu");
        System.out.println("1. Generate available books report");
        System.out.println("2. Generate borrowed books report");
        System.out.println("3. Generate overdue users report");
        // Add more options as needed
    }

    public static void addNewBook(LibraryData libraryData, Scanner scanner){

        try {
            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
    
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
    
            System.out.print("Enter the number of pages: ");
            int pages = scanner.nextInt();
    
            BookManagement bookManagement = new BookManagement();
            bookManagement.addBook(libraryData, title, author, pages);
        

        } catch (Exception e) {
            System.out.println("An error occurred while processing your book info input: " + e.getMessage());
        }

    }

}