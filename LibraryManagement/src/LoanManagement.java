import java.util.Map;
//import java.util.HashMap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Iterator;

interface LoanManage {

    void borrowBook(LibraryData libraryData, String userId, Book book);
    void returnBook(LibraryData libraryData, String userId, String bookTitle);

}

public class LoanManagement implements LoanManage{

    //private Map<String, LoanBook> borrowings = new HashMap<>();

    // Inyección de dependencias
    //private BookManagement bookManager;
    //private UserManagement userManager;

    // public LoanManagement(BookManagement bookManager, UserManagement userManager) {
    //     this.bookManager = bookManager;
    //     this.userManager = userManager;
    // }


    @Override
    public void borrowBook(LibraryData libraryData, String userId, Book book){

        //Map<String, Book> store = bookManager.getStore();
        //Map<String, User> users = userManager.getUsers();

        // Check if the book is in the store
        if (libraryData.getUsers().containsKey(book.getTitle())){
            
            // Check if the user is registered
            if(libraryData.getUsers().containsKey(userId)){

                // Create the loan book
                LoanBook loanBook = new LoanBook(book.getTitle(), book.getAuthor(), book.getPages());

                // Calculate due date as 2 weeks from the current date
                LocalDate dueDate = LocalDate.now().plus(2, ChronoUnit.WEEKS);

                // Set due date, return date, and other loan-related information
                loanBook.setDueDate(dueDate);
                loanBook.setReturnDate(null); // Initialize as not returned
                loanBook.setFine(0.0); // Initialize fine

                libraryData.getBorrowings().put(userId, loanBook); // Store the userId with the title of the book
                
                System.out.println("Book borrowed successfully.");

            } else {
                System.out.println("User not found: " + userId);
            }

        } else {
            System.out.println("Book not found: " + book.getTitle());
        }

    }

    @Override
    public void returnBook(LibraryData libraryData, String userId, String bookTitle){

        //Map<String, Book> store = bookManager.getStore();
        //Map<String, User> users = userManager.getUsers();

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(bookTitle)){
            
            // Check if the user is registered
            if(libraryData.getUsers().containsKey(userId)){

                Iterator<Map.Entry<String, LoanBook>> iterator = libraryData.getBorrowings().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, LoanBook> entry = iterator.next();
                    if (entry.getKey().equals(userId) && entry.getValue().getTitle().equals(bookTitle)) {

                        LocalDate returnDate = LocalDate.now();
                        entry.getValue().setReturnDate(returnDate);
            
                        // Calculate overdue period in days
                        long overdueDays = ChronoUnit.DAYS.between(entry.getValue().getDueDate(), returnDate);
            
                        // Set fine based on library's policy (e.g., $1 per day overdue)
                        double fineAmount = overdueDays * 1.0; // $1 per day
            
                        entry.getValue().setFine(fineAmount);

                        System.out.println("The fine amount is: " + fineAmount);

                        iterator.remove(); // Delete the matching entry
                        System.out.println("Book returned successfully.");
                        return; // Exit loop if found and remove entry
                    }
                }
                System.out.println("No matching loan found.");

            } else {
                System.out.println("User not found: " + userId);
            }

        } else {
            System.out.println("Book not found: " + bookTitle);
        }

    }

    public void generateAvailableBooksReport(LibraryData libraryData) {

        //Map<String, Book> store = bookManager.getStore();

        System.out.println("Available Books:");

        for (Map.Entry<String, Book> entry : libraryData.getBooks().entrySet()) {
            if (!libraryData.getBorrowings().containsKey(entry.getKey())) {
                System.out.println("- " + entry.getValue().getTitle() + " | " + entry.getValue().getAuthor() + " | " + entry.getValue().getPages() + " pages");
            }
        }

    }

    public void generateBorrowedBooksReport(LibraryData libraryData){

        for (Map.Entry<String, LoanBook> entry : libraryData.getBorrowings().entrySet()){
            System.out.println("Borrowed Book: " + entry.getValue().getTitle() + " Due Date: " + entry.getValue().getFine());
        }

    }

    public void generateOverdueUsersReport(LibraryData libraryData){

        LocalDate currentDate = LocalDate.now();
        for (Map.Entry<String, LoanBook> entry : libraryData.getBorrowings().entrySet()){
            if (currentDate.isAfter(entry.getValue().getDueDate())){
                long overdueDays = ChronoUnit.DAYS.between(entry.getValue().getDueDate(), currentDate);
                double fine = overdueDays * 1.0; // Calculate fine based on policy
                System.out.println("User: " + entry.getKey() + " has overdue book: " + entry.getValue().getTitle() + " Fine: " + fine + "$");
            }

        }

    }

}
