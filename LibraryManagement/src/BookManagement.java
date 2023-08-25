// import java.util.HashMap;
// import java.util.Map;

interface BookManage {
    
    void addBook(LibraryData libraryData, String title, String author, int pages);
    void removeBook(LibraryData libraryData, String title);
    void updateBook(LibraryData libraryData, String title, String author, int pages);

}

public class BookManagement implements BookManage {

    //private Map<String, Book> store = new HashMap<>();

    @Override
    public void addBook(LibraryData libraryData, String title, String author, int pages){

        Book book = new Book(title, author, pages);
        libraryData.addBook(title, book);
        System.out.println("Book added correctly.");

    }

    @Override
    public void removeBook(LibraryData libraryData, String title){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(title)){
            libraryData.removeBook(title);   
            System.out.println("Book removed correctly.");
        } else {
            System.out.println("Book not found: " + title);
        }

    }

    @Override 
    public void updateBook(LibraryData libraryData, String title, String author, int pages){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(title)){
            Book book = libraryData.getBooks().get(title);
            book.setAuthor(author);
            book.setPages(pages);
            System.out.println("Book updated correctly.");
        } else {
            System.out.println("Book not found: " + title);
        }

    }

    // // Additional methods for encapsulation
    // public Book getBook(String title) {
    //     return store.get(title);
    // }

    // public int getNumberOfBooks() {
    //     return store.size();
    // }

    // public Map<String, Book> getStore(){
    //     return store;
    // }

}
