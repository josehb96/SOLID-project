import java.util.Map;
//import java.util.HashMap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Iterator;

interface LoanManage {

    void borrowBook(LibraryData libraryData, String userId, String bookId);
    void returnBook(LibraryData libraryData, String bookId);

}

public class LoanManagement implements LoanManage{


    @Override
    public void borrowBook(LibraryData libraryData, String userId, String bookId){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(bookId)){
            
            // Check if the user is registered
            if(libraryData.getUsers().containsKey(userId)){

                Book book = libraryData.getBooks().get(bookId); // Obtain the book from the store

                // Create the loan book
                LoanBook loanBook = new LoanBook(bookId, book.getTitle(), book.getAuthor(), book.getPages(), userId);

                // Calculate due date as 2 weeks from the current date
                LocalDate dueDate = LocalDate.now().plus(2, ChronoUnit.WEEKS);

                // Set due date, return date, and other loan-related information
                loanBook.setDueDate(dueDate);
                loanBook.setReturnDate(null); // Initialize as not returned
                loanBook.setFine(0.0); // Initialize fine

                //libraryData.getBorrowings().put(userId, loanBook); // Store the userId with the book

                // Add to the borrowings
                libraryData.addBorrowing(bookId, loanBook);

                // Eliminate this book from the store
                libraryData.removeBook(bookId);
                
                System.out.println("Book borrowed successfully.");

            } else {
                System.out.println("User not found: " + userId);
            }

        } else {
            System.out.println("Book not found: " + bookId);
        }

    }

    @Override
    public void returnBook(LibraryData libraryData, String bookId){

        // Check if the book is in the borrowings
        if (libraryData.getBorrowings().containsKey(bookId)){

            Iterator<Map.Entry<String, LoanBook>> iterator = libraryData.getBorrowings().entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<String, LoanBook> entry = iterator.next();

                if (entry.getKey().equals(bookId)) {

                    LocalDate returnDate = LocalDate.now();
                    entry.getValue().setReturnDate(returnDate);
        
                    // Calculate overdue period in days
                    long overdueDays = ChronoUnit.DAYS.between(entry.getValue().getDueDate(), returnDate);
        
                    // Set fine based on library's policy (e.g., $1 per day overdue)
                    double fineAmount = overdueDays * 1.0; // $1 per day
        
                    entry.getValue().setFine(fineAmount);

                    System.out.println("The fine amount is: " + fineAmount);

                    //iterator.remove(); // Delete the matching entry

                    // Add the book back to the store
                    libraryData.addBook(bookId, libraryData.getBorrowings().get(bookId));

                    // Eliminate this book from the borrowings
                    libraryData.removeBorrowing(bookId);


                    System.out.println("Book returned successfully.");
                    return; // Exit loop if found and remove entry
                }
            }

            System.out.println("No matching loan found.");

        } else {
            System.out.println("The book is not in the borrowings list: " + bookId);
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
            System.out.println("- " + entry.getValue().getBookId() + " | " + entry.getValue().getTitle() + " | User: " + entry.getValue().getUser() + " | Due Date: " + entry.getValue().getFine());
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
                System.out.println("User: " + entry.getValue().getUser() + " has overdue book: " + entry.getValue().getBookId() + " | " + entry.getValue().getTitle() + " Fine: " + fine + "$");
            }

        }

    }

}
