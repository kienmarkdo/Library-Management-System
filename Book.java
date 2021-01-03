/**
 * @author    Kien Do
 * @version   1.0
 * @lastEdit  2021-01-01
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

    public Book(String t, String a, String g, Guest o) {
        title = t;
        author = a;
        owner = o;
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

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setOwner(Guest o) {
        owner = o;
    }

}
