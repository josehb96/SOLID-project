import java.util.Map;
//import java.util.HashMap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Iterator;

interface LoanManage {

    void borrowBook(LibraryData libraryData, String userId, String bookTitle);
    void returnBook(LibraryData libraryData, String userId, String bookTitle);

}

public class LoanManagement implements LoanManage{


    @Override
    public void borrowBook(LibraryData libraryData, String userId, String bookTitle){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(bookTitle)){
            
            // Check if the user is registered
            if(libraryData.getUsers().containsKey(userId)){

                Book book = libraryData.getBooks().get(bookTitle);

                // Create the loan book
                LoanBook loanBook = new LoanBook(book.getTitle(), book.getAuthor(), book.getPages());

                // Calculate due date as 2 weeks from the current date
                LocalDate dueDate = LocalDate.now().plus(2, ChronoUnit.WEEKS);

                // Set due date, return date, and other loan-related information
                loanBook.setDueDate(dueDate);
                loanBook.setReturnDate(null); // Initialize as not returned
                loanBook.setFine(0.0); // Initialize fine

                //libraryData.getBorrowings().put(userId, loanBook); // Store the userId with the book

                // Add to the borrowings
                libraryData.addBorrowing(userId, loanBook);

                // Eliminate this book from the store
                libraryData.removeBook(bookTitle);
                
                System.out.println("Book borrowed successfully.");

            } else {
                System.out.println("User not found: " + userId);
            }

        } else {
            System.out.println("Book not found: " + bookTitle);
        }

    }

    @Override
    public void returnBook(LibraryData libraryData, String userId, String bookTitle){

        // Check if the user is in the borrowers
        if (libraryData.getBorrowings().containsKey(userId)){

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

                    //iterator.remove(); // Delete the matching entry

                    // Add to the store
                    libraryData.addBook(bookTitle, libraryData.getBorrowings().get(userId));

                    // Eliminate this book from the borrowings
                    libraryData.removeBorrowing(userId);


                    System.out.println("Book returned successfully.");
                    return; // Exit loop if found and remove entry
                }
            }

            System.out.println("No matching loan found.");

        } else {
            System.out.println("The user is not in the borrowers list: " + userId);
        }


    }

    public void generateAvailableBooksReport(LibraryData libraryData) {

        System.out.println();
        System.out.println("Available Books:");

        for (Map.Entry<String, Book> entry : libraryData.getBooks().entrySet()) {
            if (!libraryData.getBorrowings().containsKey(entry.getKey())) {
                System.out.println("- " + entry.getValue().getBookId() + " | " + entry.getValue().getTitle() + " | " + entry.getValue().getAuthor() + " | " + entry.getValue().getPages() + " pages");
            }
        }

    }

    public void generateBorrowedBooksReport(LibraryData libraryData){

        System.out.println();
        System.out.println("Borrowed Books:");

        for (Map.Entry<String, LoanBook> entry : libraryData.getBorrowings().entrySet()){
            System.out.println("- " + entry.getValue().getBookId() + " | " + entry.getValue().getTitle() + " Due Date: " + entry.getValue().getFine());
        }

    }

    public void generateOverdueUsersReport(LibraryData libraryData){

        System.out.println();
        System.out.println("Overdue Users:");

        LocalDate currentDate = LocalDate.now();
        for (Map.Entry<String, LoanBook> entry : libraryData.getBorrowings().entrySet()){
            if (currentDate.isAfter(entry.getValue().getDueDate())){
                long overdueDays = ChronoUnit.DAYS.between(entry.getValue().getDueDate(), currentDate);
                double fine = overdueDays * 1.0; // Calculate fine based on policy
                System.out.println("User: " + entry.getKey() + " has overdue book: " + entry.getValue().getBookId() + " | " + entry.getValue().getTitle() + " Fine: " + fine + "$");
            }

        }

    }

}
