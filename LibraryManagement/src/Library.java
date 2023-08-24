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
            scanner.nextLine(); // Clean the buffer

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

        System.out.println("Book Management Menu");
        System.out.println("1. Add new book");
        System.out.println("2. Remove book");
        System.out.println("3. Update book details");

        choice = scanner.nextInt();
        scanner.nextLine(); // Clean the buffer
        
        switch (choice) {
            case 1:
                addNewBook(libraryData, scanner);
                break;
            case 2:
                //removeBook(libraryData, scanner);
                break;
            case 3:
                //updateBook(libraryData, scanner);
                break;
            case 0:
                System.out.println("Returning to the main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

    }

    public static void userManagementMenu(LibraryData libraryData, Scanner scanner) {

        System.out.println("User Management Menu");
        System.out.println("1. Register new user");
        System.out.println("2. Update user information");
        System.out.println("3. Deactivate user account");

    }

    public static void loanManagementMenu(LibraryData libraryData, Scanner scanner) {

        System.out.println("Loan Management Menu");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. Calculate fines");

    }

    public static void reportGenerationMenu(LibraryData libraryData, Scanner scanner) {

        int choice;

        System.out.println("Report Generation Menu");
        System.out.println("1. Generate available books report");
        System.out.println("2. Generate borrowed books report");
        System.out.println("3. Generate overdue users report");
    
        choice = scanner.nextInt();
        scanner.nextLine(); // Clean the buffer

        switch (choice) {
            case 1:
                LoanManagement loanManagement = new LoanManagement();
                loanManagement.generateAvailableBooksReport(libraryData);
                break;
            case 2:
                //generateBorrowedBooksReport(libraryData);
                break;
            case 3:
                //generateOverdueUsersReport(libraryData);
                break;
            case 0:
                System.out.println("Returning to the main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

    }

    public static void addNewBook(LibraryData libraryData, Scanner scanner){

        try {
            System.out.println("Enter the book title: ");
            String title = scanner.nextLine();
    
            System.out.println("Enter the author: ");
            String author = scanner.nextLine();
    
            System.out.println("Enter the number of pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
    
            BookManagement bookManagement = new BookManagement();
            bookManagement.addBook(libraryData, title, author, pages);
        

        } catch (Exception e) {
            System.out.println("An error occurred while processing your book info input: " + e.getMessage());
        }

    }

}