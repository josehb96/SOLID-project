import java.util.HashMap;
import java.util.Map;

interface BookManage {
    
    void addBook(String title, String author, int pages);
    void removeBook(String title);
    void updateBook(String title, String author, int pages);

}

public class BookManagement implements BookManage {

    private Map<String, Book> store = new HashMap<>();

    @Override
    public void addBook(String title, String author, int pages){

        Book book = new Book(title, author, pages);
        store.put(title, book);

    }

    @Override
    public void removeBook(String title){

        // Check if the book is in the store
        if (store.containsKey(title)){
            store.remove(title);   
        } else {
            System.out.println("Book not found " + title);
        }

    }

    @Override 
    public void updateBook(String title, String author, int pages){

        // Check if the book is in the store
        if (store.containsKey(title)){
            Book book = getBook(title);
            book.setAuthor(author);
            book.setPages(pages);
        } else {
            System.out.println("Book not found: " + title);
        }

    }

    // Additional methods for encapsulation
    public Book getBook(String title) {
        return store.get(title);
    }

    public int getNumberOfBooks() {
        return store.size();
    }
    

}
