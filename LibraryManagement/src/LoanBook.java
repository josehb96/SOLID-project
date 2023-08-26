import java.time.LocalDate;

public class LoanBook extends Book {
    private LocalDate dueDate;   // Due date
    private LocalDate returnDate; // Return date
    private double fine;          // Associated fine
    private String userId; // Associated userId

    public LoanBook(String bookId, String title, String author, int pages, String userId) {
        super(title, author, pages);
        // Set initial values for attributes
        dueDate = null;
        returnDate = null;
        fine = 0.0;
        this.userId = userId;
        setBookId(bookId); // With this we make sure that is the same book id in the loan book
    }

    public String getUser(){
        return userId;
    }

    public void setUser(String userId){
        this.userId = userId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}

