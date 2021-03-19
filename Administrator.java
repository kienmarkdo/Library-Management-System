/**
 * User.java -> Administrator.java
 * An administrator is a subclass of User therefore an administrator has login credentials (username, password).
 * Administrator.java represents the data and actions of a library administrator.
 * An administrator has special access to the library such as managing books, guests and viewing sensitive information.
 *
 * @author    Kien Do
 */

public class Administrator extends User {


    public Administrator() {
        super(null, null, true);
    }

    public Administrator(String _username, String _password) {
        setUsername(_username);
        setPassword(_password);
    }
}
