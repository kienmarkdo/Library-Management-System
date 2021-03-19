/**
 * Book.java is a class that represents a book stored in the library
 *
 * @author    Kien Do
 */
public class Book {
    private String title;
    private String author;
    private Guest owner;

    public Book() {
        title = "";
        author = "";
        owner = null;
    }

    public Book(String _title, String _author, Guest _owner) {
        title = _title;
        author = _author;
        owner = _owner;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Owner: " + owner);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public User getOwner() {
        return owner;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public void setAuthor(String _author) {
        author = _author;
    }

    public void setOwner(Guest _owner) {
        owner = _owner;
    }

}
