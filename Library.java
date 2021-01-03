/**
 * @author    Kien Do
 * @version   1.0
 * @lastEdit  2021-01-01
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Guest> guestList;
    private ArrayList<Administrator> adminList;
    private static int totalBooks;
    private static int totalGuests;

    public Library() {
        totalBooks = 0;
    }

    public void displayAllBooks() {
        for (int i = 0; i < totalBooks; i++) {
            System.out.println((i + 1) + ". " + bookList.get(i).getAuthor());
        }
    }

    public void displayAllAvailableBooks() {

    }

    public void addBook() {

    }

    public void removeBook() {

    }

    public void modifyBook() {

    }

    public void libraryMenu() {
        Scanner input = new Scanner(System.in);
        String userInput;
        String passInput;
        boolean loginSuccess = false;
        int maxTries = 0;

        do {
            System.out.print("Enter admin username: ");
            userInput = input.nextLine();
            System.out.println("Enter admin password: ");
            passInput = input.nextLine();

            for (Administrator i: adminList) {
                if (userInput == i.getUsername() && passInput == i.getPassword()) {
                    loginSuccess = true;
                    System.out.println("Login Successful!");
                    break;
                }
            }
            maxTries++;
        } while(loginSuccess == false && maxTries < 3);

        if (loginSuccess == false && maxTries < 3) {
            System.out.println("ERROR: Exiting systems. Max tries reached.");
            return;
        }
        else {
            System.out.println("Library Administrator Menu.\n");
            System.out.println("1. View all available books.");
            System.out.println("2. Search for book(s) by feature.");
            System.out.println("3. Add a book.");
            System.out.println("4. Remove a book.");
            System.out.println("5. Modify a book's feature(s).");
        }

    }

    public boolean verifyAdmin(String _username, String _password) {
        /**
         * Verifies if the given administrator credentials are valid or not.
         * (String username, String password) -> boolean
         */
        boolean isValidAdmin = false;

        for(Administrator i: adminList) {
            if(i.getUsername() == _username && i.getPassword() == _password) {
                isValidAdmin = true;
                break;
            }
        }

        return isValidAdmin;
    }

    public void verifyGuest() {

    }
}
