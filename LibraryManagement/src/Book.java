import java.util.UUID;

public class Book {

    // Attributes
    private String bookId;
    private String title;
    private String author;
    private int pages;

    // Constructor
    public Book (String title, String author, int pages){
        this.bookId = UUID.randomUUID().toString(); // Generate a random bookId
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Getters

    public String getBookId(){
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
    
    public int getPages(){
        return pages;
    }

    // Setters

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPages(int pages){
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + pages;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (pages != other.pages)
            return false;
        return true;
    }

    

}
