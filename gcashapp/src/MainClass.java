package gcashapp.src;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication userAuth = new UserAuthentication();
        CheckBalance checkBalance = new CheckBalance();
        CashIn cashIn = new CashIn();
        CashTransfer cashTransfer = new CashTransfer();

        System.out.println("Welcome to GcashApp");
        System.out.print("Enter your User ID: ");
        int userId = scanner.nextInt();

        if (userAuth.authenticate(userId)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Cash In");
                System.out.println("3. Cash Transfer");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance.checkBalance(userId);
                        break;
                    case 2:
                        System.out.print("Enter amount to cash in: ");
                        double cashInAmount = scanner.nextDouble();
                        cashIn.cashIn(userId, cashInAmount);
                        break;
                    case 3:
                        System.out.print("Enter recipient User ID: ");
                        int recipientId = scanner.nextInt();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        cashTransfer.transfer(userId, recipientId, transferAmount);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using GcashApp.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting application.");
        }
        scanner.close();
    }
}
