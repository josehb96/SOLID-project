interface BookManage {
    
    void addBook(LibraryData libraryData, String title, String author, int pages);
    void removeBook(LibraryData libraryData, String bookId);
    void updateBook(LibraryData libraryData, String bookId, String title, String author, int pages);

}

public class BookManagement implements BookManage {

    @Override
    public void addBook(LibraryData libraryData, String title, String author, int pages){

        Book book = new Book(title, author, pages);
        libraryData.addBook(book.getBookId(), book);
        System.out.println("Book added correctly.");

    }

    @Override
    public void removeBook(LibraryData libraryData, String bookId){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(bookId)){
            libraryData.removeBook(bookId);   
            System.out.println("Book removed correctly.");
        } else {
            System.out.println("Book not found: " + bookId);
        }

    }

    @Override 
    public void updateBook(LibraryData libraryData, String bookId, String title, String author, int pages){

        // Check if the book is in the store
        if (libraryData.getBooks().containsKey(bookId)){
            Book book = libraryData.getBooks().get(bookId);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPages(pages);
            System.out.println("Book updated correctly.");
        } else {
            System.out.println("Book not found: " + bookId);
        }

    }

}
