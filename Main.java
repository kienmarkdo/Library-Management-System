/**
 * Library Management System using files
 *
 * @author    Kien Do
 * @version   1.0
 *
 * Relevant Classes
 * - Library.java
 * - User.java (abstraction)
 * - Guest.java (extends User)
 * - Administrator.java (extends User)
 */

import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class Main {

    public static String ADMINCREDENTIALSFILENAME = "admin_credentials_data.txt";
    public static String GUESTCREDENTIALSFILENAME = "guest_credentials_data.txt";

    /********************************
     * Miscellaneous methods
     *******************************/

    public static void clearScreen() {
        for (int i = 0; i < 50 ; i++) {
            System.out.println();
        }
    }

    public static void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue. . .");
        new java.util.Scanner(System.in).nextLine();
    }

    /********************************
     * File handling methods
     *******************************/

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

    /********************************
     * Menu methods
     *******************************/

    static void displayWelcomeMenu() {
        System.out.println("Select an option below:");
        System.out.println("1. Login as Administrator / Librarian");
        System.out.println("2. Login as Guest");
        System.out.println("3. Register new account");
        System.out.println("0. Exit Library\n");
    }

    static void adminMenu() {
        System.out.println("What would you like to do today?");
        System.out.println("1. View all available books");
        System.out.println("2. Search a book by its features");
        System.out.println("3. Add a book to the library");
        System.out.println("4. Remove a book from the library");
        System.out.println("5. Modify a book's features");
        System.out.println("0. Exit");
    }

    static void guestMenu() {

    }

    /********************************
     * Authentication methods
     *******************************/

    static void adminLogin() {
        Scanner input = new Scanner(System.in);
        String usernameInput = null;
        String passwordInput = null;
        Administrator admin = new Administrator();

        System.out.println("Please enter your login credentials.");
        System.out.println("Username: ");
        usernameInput = input.nextLine();
        System.out.println("Password: ");
        passwordInput = input.nextLine();


    }

    static void guestLogin() {

    }

    static void registerUser() {
        Scanner input = new Scanner(System.in);

        String menuOption = null;
        boolean endProgram = false;
        String newUsername = null;
        String newPassword = null;

        while(menuOption == null && endProgram == false) {
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

            switch(menuOption) {
                // add new administrator
                case "1":
                    Administrator newAdmin = new Administrator(newUsername, newPassword);
                    // NOTE: Users may enter spaces in their username and/or password, causing this to malfunction
                    // Fix later
                    // Currently organizes user data as follows
                    // "username password\n" <- see how the username and password are separated by a space
                    createFile(ADMINCREDENTIALSFILENAME);
                    writeToFile(ADMINCREDENTIALSFILENAME, newUsername + " " + newPassword);
                    break;
                // add new guest
                case "2":
                    Guest newGuest = new Guest(newUsername, newPassword);
                    createFile(GUESTCREDENTIALSFILENAME);
                    writeToFile(GUESTCREDENTIALSFILENAME, newUsername + " " + newPassword);
                    break;
                // quit program
                case "0":
                    System.out.println("Exiting current menu . . .");
                    endProgram = true;
                    break;
                default:
                    System.out.println("ERROR: Please enter a number corresponding to an option above then press ENTER");
                    pressAnyKeyToContinue();
                    menuOption = null;
                    break;
            } // switch


        } // while loop

        // close Scanner class
        input.close();

    }

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

            switch (menuOption) {
                case "1":
                    clearScreen();
                    adminLogin();
                    adminMenu();
                    break;
                case "2":
                    clearScreen();
                    guestMenu();
                    break;
                case "3":
                    clearScreen();
                    registerUser();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    endProgram = true;
                    break;
                default:
                    System.out.println("ERROR: Please enter a number corresponding to one of the choices above then press ENTER.");
                    pressAnyKeyToContinue();
                    clearScreen();
                    menuOption = null;
                    break;
            } // switch
        } // while loop

        input.close();


    }
}
