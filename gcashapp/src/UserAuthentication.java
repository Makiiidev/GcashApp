package gcashapp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAuthentication {

    public boolean authenticate(int userId) {
        // Implement authentication logic
        return true; // Return true if authenticated, false otherwise
    }

    static class User {
        int id;
        String name;
        String email;
        String phoneNumber;
        String pin;

        User(int id, String name, String email, String phoneNumber, String pin) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.pin = pin;
        }
    }

    private List<User> users = new ArrayList<>();
    private int userIdCounter = 1; 
    private User loggedInUser = null; 

    public void register(String name, String email, String phoneNumber, String pin) {
        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || pin.isEmpty()) {
            System.out.println("Validation failed: All fields are required.");
            return;
        }

        User newUser = new User(userIdCounter++, name, email, phoneNumber, pin);
        users.add(newUser);
        System.out.println("User registered successfully! User ID: " + newUser.id);
    }

    public void login(int id, String pin) {
        for (User user : users) {
            if (user.id == id) {
                if (user.pin.equals(pin)) {
                    loggedInUser = user;
                    System.out.println("Login successful! Welcome, " + user.name);
                    return;
                } else {
                    System.out.println("Error: Invalid PIN.");
                    return;
                }
            }
        }
        System.out.println("Error: User not found.");
    }

    public void changePin(String newPin) {
        if (loggedInUser == null) {
            System.out.println("Error: No user is currently logged in.");
            return;
        }

        loggedInUser.pin = newPin;
        System.out.println("PIN changed successfully!");
    }

    public void logout() {
        if (loggedInUser == null) {
            System.out.println("Error: No user is currently logged in.");
        } else {
            System.out.println("User logged out successfully.");
            loggedInUser = null;
        }
    }

    public static void main(String[] args) {
        UserAuthentication app = new UserAuthentication();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change PIN");
            System.out.println("4. Logout");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    app.register(name, email, phoneNumber, pin);
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String loginPin = scanner.nextLine();
                    app.login(id, loginPin);
                    break;
                case 3:
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();
                    app.changePin(newPin);
                    break;
                case 4:
                    app.logout();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
