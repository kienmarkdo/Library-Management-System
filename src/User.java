/**
 * User.java represents the general data for a user to log in to the library system
 *
 * @author    Kien Do
 */

abstract public class User {
    private String username;
    private String password;
    protected final boolean isAdmin;

    public User() {
        username = null;
        password = null;
        isAdmin = false;
    }

    public User(String _username, String _password, boolean _isAdmin) {
        username = _username;
        password = _password;
        isAdmin = _isAdmin;
    }

    public String toString() {
        return username;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String _username) {
        username = _username;
    }
    public void setPassword(String _password) {
        password = _password;
    }
}
