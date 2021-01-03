/**
 * @author    Kien Do
 * @version   1.0
 * @lastEdit  2021-01-01
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

    public void removeBook(Book _book) {
        /**
         * Removes a book from a library by... index? name? author? To be determined
         */
        booksBorrowing.remove(_book);
    }


}
