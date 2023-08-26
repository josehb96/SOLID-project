import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        LibraryData libraryData = new LibraryData();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println();
            System.out.println("Welcome to the Library");
            System.out.println("1. Book Management");
            System.out.println("2. User Management");
            System.out.println("3. Loan Management");
            System.out.println("4. Report Generation");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()){

                choice = scanner.nextInt();
                scanner.nextLine(); // Clean newline character from buffer

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

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = 1; // Set choice to an invalid value to continue loop
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void bookManagementMenu(LibraryData libraryData, Scanner scanner) {

        int choice;

        do {

            System.out.println();
            System.out.println("Book Management Menu");
            System.out.println("1. Add new book");
            System.out.println("2. Remove book");
            System.out.println("3. Update book details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()){

                choice = scanner.nextInt();
                scanner.nextLine(); // Clean newline character from buffer
            
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
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = 1; // Set choice to an invalid value to continue loop
            }

        } while (choice != 0);

    }

    public static void userManagementMenu(LibraryData libraryData, Scanner scanner) {

        int choice;

        do {

            System.out.println();
            System.out.println("User Management Menu");
            System.out.println("1. Register new user");
            System.out.println("2. Update user information");
            System.out.println("3. Deactivate user account");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()){

                choice = scanner.nextInt();
                scanner.nextLine(); // Clean newline character from buffer
            
                switch (choice) {
                    case 1:
                        registerUser(libraryData, scanner);
                        break;
                    case 2:
                        updateUser(libraryData, scanner);
                        break;
                    case 3:
                        deactivateUser(libraryData, scanner);
                        break;
                    case 0:
                        System.out.println("Returning to the main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            }
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = 1; // Set choice to an invalid value to continue loop
            }

        } while (choice != 0);

    }

    public static void loanManagementMenu(LibraryData libraryData, Scanner scanner) {

        int choice;

        do{

            System.out.println();
            System.out.println("Loan Management Menu");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
        
            if (scanner.hasNextInt()){

                choice = scanner.nextInt();
                scanner.nextLine(); // Clean newline character from buffer

                switch (choice) {
                    case 1:
                        borrowBook(libraryData, scanner);
                        break;
                    case 2:
                        returnBook(libraryData, scanner);
                        break;
                    case 0:
                        System.out.println("Returning to the main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = 1; // Set choice to an invalid value to continue loop
            }

        } while (choice != 0);

    }

    public static void reportGenerationMenu(LibraryData libraryData, Scanner scanner) {

        int choice;
        LoanManagement loanManagement = new LoanManagement();
        UserManagement userManagement = new UserManagement();

        do{

            System.out.println();
            System.out.println("Report Generation Menu");
            System.out.println("1. Generate available books report");
            System.out.println("2. Generate registered users report");
            System.out.println("3. Generate borrowed books report");
            System.out.println("4. Generate overdue users report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
        
            if (scanner.hasNextInt()){

                choice = scanner.nextInt();
                scanner.nextLine(); // Clean newline character from buffer

                switch (choice) {
                    case 1:
                    
                        loanManagement.generateAvailableBooksReport(libraryData);
                        break;
                    case 2:
                        userManagement.generateRegisteredUsersReport(libraryData);
                        break;
                    case 3:
                        loanManagement.generateBorrowedBooksReport(libraryData);
                        break;
                    case 4:
                        loanManagement.generateOverdueUsersReport(libraryData);
                        break;
                    case 0:
                        System.out.println("Returning to the main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input from buffer
                choice = 1; // Set choice to an invalid value to continue loop
            }

        } while (choice != 0);

    }

    public static void addNewBook(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
    
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
    
            System.out.print("Enter the number of pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
    
            BookManagement bookManagement = new BookManagement();
            bookManagement.addBook(libraryData, title, author, pages);
        
        } catch (Exception e) {
            System.out.println("An error occurred while processing your book info input: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void removeBook(LibraryData libraryData, Scanner scanner){
        
        System.out.println();

        try{

            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();

            BookManagement bookManagement = new BookManagement();
            bookManagement.removeBook(libraryData, title);

        } catch (Exception e){
            System.out.println("An error occurred while removing the book indicated: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void updateBook(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try{

            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
    
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
    
            System.out.print("Enter the number of pages: ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
    
            BookManagement bookManagement = new BookManagement();
            bookManagement.updateBook(libraryData, title, author, pages);

        } catch (Exception e){
            System.out.println("An error occurred while updating the book indicated: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void registerUser(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the id: ");
            String userId = scanner.nextLine();

            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter the age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
    
            System.out.print("Enter the email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter the phone number: ");
            String phoneNumber = scanner.nextLine();
    
            UserManagement userManagement = new UserManagement();
            userManagement.registerUser(libraryData, userId, name, age, email, phoneNumber);
        
        } catch (Exception e) {
            System.out.println("An error occurred while processing your user info input: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void updateUser(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the id: ");
            String userId = scanner.nextLine();

            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter the age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Clean the buffer
    
            System.out.print("Enter the email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter the phone number: ");
            String phoneNumber = scanner.nextLine();
    
            UserManagement userManagement = new UserManagement();
            userManagement.updateUser(libraryData, userId, name, age, email, phoneNumber);
        
        } catch (Exception e) {
            System.out.println("An error occurred while updating the user data: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void deactivateUser(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the id: ");
            String userId = scanner.nextLine();
    
            UserManagement userManagement = new UserManagement();
            userManagement.deactivateUser(libraryData, userId);
        
        } catch (Exception e) {
            System.out.println("An error occurred while removing the user: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void borrowBook(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the user id: ");
            String userId = scanner.nextLine();

            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
    
            LoanManagement loanManagement = new LoanManagement();
            loanManagement.borrowBook(libraryData, userId, title);
        
        } catch (Exception e) {
            System.out.println("An error occurred while borrowing the book: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

    public static void returnBook(LibraryData libraryData, Scanner scanner){

        System.out.println();

        try {

            System.out.print("Enter the user id: ");
            String userId = scanner.nextLine();

            System.out.print("Enter the book title: ");
            String title = scanner.nextLine();
    
            LoanManagement loanManagement = new LoanManagement();
            loanManagement.returnBook(libraryData, userId, title);
        
        } catch (Exception e) {
            System.out.println("An error occurred while returning the book: " + e.getMessage());
            scanner.nextLine(); // Clean the buffer
        }

    }

}