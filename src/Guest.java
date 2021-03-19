/**
 * User.java -> Guest.java
 * A guest is a subclass of User therefore a guest has login credentials (username, password).
 * Guest.java represents the data and actions that are pertinent to a regular library user.
 * For example, a guest can borrow and return books from the library.
 *
 * @author    Kien Do
 */

import java.util.ArrayList;

public class Guest extends User {
    private ArrayList<Book> booksBorrowing;

    public Guest() {
        super(null, null, false);
        booksBorrowing = new ArrayList<Book>();
    }

    public Guest(String _username, String _password) {
        setUsername(_username);
        setPassword(_password);
    }

    public void addBook(Book newBook) {
        booksBorrowing.add(newBook);
    }

    /**
     * Removes a book from a library by... index? name? author? To be determined
     */
    public void removeBook(Book _book) {

        booksBorrowing.remove(_book);
    }


}
