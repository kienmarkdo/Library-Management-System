import java.io.*;
import java.util.Scanner;
import java.lang.*;

/**
 * Library Management System using files
 * This class represents the main menu of the library management system.
 *
 * @author    Kien Do
 *
 * Relevant Classes
 * - Library.java
 * - User.java (abstraction)
 * - Guest.java (extends User)
 * - Administrator.java (extends User)
 */

public class Main {

    public static String ADMINCREDENTIALSFILENAME = "admin_credentials_data.txt";
    public static String GUESTCREDENTIALSFILENAME = "guest_credentials_data.txt";

    /********************************
     * Miscellaneous methods
     *******************************/

    /**
     * Clears the screen
     */
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Stops the flow on the screen and displays "Press any key to continue"
     */
    public static void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue. . .");
        new java.util.Scanner(System.in).nextLine();
    }

    /********************************
     * File handling methods
     *******************************/

    /**
     * Creates a new file and ads the file into the library
     * @param fileName
     * Takes the name of the file to be created
     */
    static void createFile(String fileName) {
        try {
            File f = new File(fileName);
            if (f.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: An error occurred at createFile() in file handling functions");
            e.printStackTrace();
        }

    }

    /**
     * Writes text in the form of a String to an existing file
     * @param fileName
     * Name of the file to be written to
     * @param data
     * A String of data to be written to the file
     */
    static void writeToFile(String fileName, String data) {
        try {
            FileWriter w = new FileWriter(fileName, true); // Help on how to add to file here: https://stackoverflow.com/a/1625266
            w.write(data + "\n");
            w.close();
            System.out.println("Data added successfully.");
        }
        catch(IOException e) {
            System.out.println("ERROR: An error occurred at writeToFile() in file handling functions");
            e.printStackTrace();
        }
    }

    /**
     * Verifies if the username and password exists AND belongs to the same user in the system.
     * Returns true if the username and password both exist and match in the credentials file.
     *
     * @param fileName
     * Name of the file containing username and password data
     * @param username
     * The username
     * @param password
     * The password
     * @return isValid
     */
    static boolean verifyUsernameAndPassword(String fileName, String username, String password) {
        boolean isValid = false;

        try {
            File f = new File(fileName);
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                String userData = read.nextLine();
                String[] temp = userData.split(" ");
                if(username.equals(temp[0]) && password.equals(temp[1])) {
                    isValid = true;
                    break;
                }
            }
            read.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found. Cannot verify username and password.");
            e.printStackTrace();
        }

//        if (isValid)
//            System.out.println("SUCCESS: Username and password found in the system.");
//        else
//            System.out.println("ERROR: Username and password not found in the system.");

        return isValid;
    } // end of verifyUsernameAndPassword

    /**
     * Checks whether a username exists in a given file or not.
     * @param fileName
     * Name of the file containing username data
     * @param username
     * Name of the username being checked
     * @return isExist
     * True if the username already exists. Else, false.
     */
    static boolean verifyUsername(String fileName, String username) {
        boolean isExist = false;

        try {
            File f = new File(fileName);
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                String userData = read.nextLine();
                String[] temp = userData.split(" ");
                if(username.equals(temp[0])) {
                    isExist = true;
                    break;
                }
            }
            read.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found. Cannot verify username.");
            e.printStackTrace();
        }

        return isExist;

    } // end of verifyUsername

    /********************************
     * Menu methods
     *******************************/

    /**
     * Displays the welcome menu
     */
    static void displayWelcomeMenu() {
        System.out.println("Select an option below:");
        System.out.println("1. Login as Administrator / Librarian");
        System.out.println("2. Login as Guest");
        System.out.println("3. Register new account");
        System.out.println("0. Exit Library\n");
    }

    /**
     * Menu for administrators
     */
    static void adminMenu() {
        System.out.println("What would you like to do today?");
        System.out.println("1. View all available books");
        System.out.println("2. Search a book by its features");
        System.out.println("3. Add a book to the library");
        System.out.println("4. Remove a book from the library");
        System.out.println("5. Modify a book's features");
        System.out.println("0. Exit");
    }

    /**
     * Menu for guests
     */
    static void guestMenu() {

    }

    /********************************
     * Authentication methods
     *******************************/

    /**
     * Checks to see if there are spaces in a string or not.
     * Returns true is there is a space character in the string, false if not.
     * @param str
     * The string to be checked for spaces
     * @return isSpace
     * Returns true is there is a space character in the string, false if not.
     */
    static boolean checkSpacesInString(String str) {
        boolean isSpace = false;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                isSpace = true;
                break;
            }
        }

        return isSpace;
    }

    /**
     * Login page for administrators
     * Allows a maximum of 5 tries
     */
    static void adminLogin() {
        Scanner input = new Scanner(System.in);

        String usernameInput = null;
        String passwordInput = null;
        Administrator admin = new Administrator();
        boolean loginSuccess = false;
        String tryAgain = null;

        do {

            while (usernameInput == null || passwordInput == null) {
                System.out.println("Please enter your login credentials.\n");
                System.out.print("Username: ");
                usernameInput = input.nextLine();
                System.out.print("Password: ");
                passwordInput = input.nextLine();


                if (checkSpacesInString(usernameInput) || checkSpacesInString(passwordInput)) {
                    System.out.println("ERROR: Your username AND password MUST NOT contain spaces.");
                    usernameInput = null;
                    passwordInput = null;
                    pressAnyKeyToContinue();
                    clearScreen();
                }

            } // while loop

            if (verifyUsernameAndPassword(ADMINCREDENTIALSFILENAME, usernameInput, passwordInput)) {
                System.out.println("Login success!\n");
                loginSuccess = true;
            }
            else {
                System.out.println("Failed to login! No matching admin data found.\n");
                loginSuccess = false;
                usernameInput = null;
                passwordInput = null;
            }

            if (!loginSuccess) {

                while (tryAgain == null) {
                    System.out.println("Would you like to try to login again?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    tryAgain = input.nextLine();
                    tryAgain.replaceAll("\\s+","");

                    // simplified by Intellij. Condition was initially ->
                    // !(tryAgain.equals("1") ^ tryAgain.equals("2")
                    if ((tryAgain.equals("1") == tryAgain.equals("2"))) {
                        System.out.println("ERROR: Please enter 1 to Try again and 2 to Cancel.");
                        tryAgain = null;
                        pressAnyKeyToContinue();
                    } // if

                    clearScreen();

                } // while
            } // if

        } while(!loginSuccess && tryAgain.equals("1"));

        pressAnyKeyToContinue();

        input.close();
    }

    /**
     * Login page for guests
     */
    static void guestLogin() {

    }

    /**
     * Registers a new user into the library
     * Asks the user to enter in a new username and password
     */
    static void registerUser() {
        Scanner input = new Scanner(System.in);

        String menuOption = null;
        boolean endProgram = false;
        String newUsername = null;
        String newPassword = null;

        while(menuOption == null || !endProgram) {
            System.out.println("Select the type of account for which you would like to register");
            System.out.println("1. Administrator / Librarian");
            System.out.println("2. Guest");
            System.out.println("0. Quit");
            menuOption = input.nextLine();
            menuOption.replaceAll("\\s+", "");

            if (menuOption.equals("1") || menuOption.equals("2")) {
                // NOTE: add a restriction where the input cannot contain spaces
                System.out.print("Enter username: ");
                newUsername = input.nextLine();
                System.out.print("Enter password: ");
                newPassword = input.nextLine();
            }

            // add new administrator
            // NOTE: Users may enter spaces in their username and/or password, causing this to malfunction
            // Fix later
            // Currently organizes user data as follows
            // "username password\n" <- see how the username and password are separated by a space
            // add new guest
            // quit program
            switch (menuOption) {
                case "1" -> {
                    Administrator newAdmin = new Administrator(newUsername, newPassword);
                    if (!verifyUsername(ADMINCREDENTIALSFILENAME, newUsername)) {
                        createFile(ADMINCREDENTIALSFILENAME);
                        writeToFile(ADMINCREDENTIALSFILENAME, newUsername + " " + newPassword);

                        System.out.println("Registration successful!");
                        endProgram = true;
                    } else {
                        System.out.println("ERROR: This username already exists.");
                        pressAnyKeyToContinue();
                    }
                }
                case "2" -> {
                    Guest newGuest = new Guest(newUsername, newPassword);
                    if (!verifyUsername(GUESTCREDENTIALSFILENAME, newUsername)) {
                        createFile(GUESTCREDENTIALSFILENAME);
                        writeToFile(GUESTCREDENTIALSFILENAME, newUsername + " " + newPassword);

                        System.out.println("Registration successful!");
                        endProgram = true;
                    } else {
                        System.out.println("ERROR: This username already exists.");
                        pressAnyKeyToContinue();
                    }
                }
                case "0" -> {
                    System.out.println("Exiting current menu . . .");
                    endProgram = true;
                }
                default -> {
                    System.out.println("ERROR: Please enter a number corresponding to an option above then press ENTER");
                    pressAnyKeyToContinue();
                    menuOption = null;
                }
            } // switch


        } // while loop

        // close Scanner class
        input.close();

    } // end of registerUser

    /********************************
     * Main method
     *******************************/

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String menuOption = null;
        boolean endProgram = false;

        while(menuOption == null && endProgram == false) {
            //displayWelcomeMenu();
            System.out.println("Select an option below:");
            System.out.println("1. Login as Administrator / Librarian");
            System.out.println("2. Login as Guest");
            System.out.println("3. Register new account");
            System.out.println("0. Exit Library");

            menuOption = input.nextLine();
            menuOption.replaceAll("\\s+", ""); // remove all white spaces

            clearScreen();

            switch (menuOption) {
                case "1" -> {
                    adminLogin();
                    adminMenu();
                }
                case "2" -> guestMenu();
                case "3" -> registerUser();
                case "0" -> {
                    System.out.println("Exiting...");
                    endProgram = true;
                }
                default -> {
                    System.out.println("ERROR: Please enter a number corresponding to one of the choices above then press ENTER.");
                    pressAnyKeyToContinue();
                    clearScreen();
                    menuOption = null;
                }
            } // switch
        } // while loop

        input.close();


    } // end of main
} // end of Main.java
