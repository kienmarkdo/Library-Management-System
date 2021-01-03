/**
 * @author    Kien Do
 * @version   1.0
 * @lastEdit  2021-01-01
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
