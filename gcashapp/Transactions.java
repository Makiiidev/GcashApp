package gcashapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transactions {

    static class Account {
        int accountId;
        String accountHolder;
        double balance;

        Account(int accountId, String accountHolder, double balance) {
            this.accountId = accountId;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
    }

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(int accountId, String accountHolder, double initialBalance) {
        accounts.add(new Account(accountId, accountHolder, initialBalance));
    }

    private Account findAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.accountId == accountId) {
                return account;
            }
        }
        return null;
    }

    public void transferFunds(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = findAccountById(fromAccountId);
        Account toAccount = findAccountById(toAccountId);

        if (fromAccount == null) {
            System.out.println("Error: Source account not found.");
            return;
        }
        if (toAccount == null) {
            System.out.println("Error: Destination account not found.");
            return;
        }
        if (fromAccount.balance < amount) {
            System.out.println("Error: Insufficient funds in source account.");
            return;
        }

        fromAccount.balance -= amount;
        toAccount.balance += amount;

        System.out.println("Transfer successful!");
        System.out.println("New balance of " + fromAccount.accountHolder + ": PHP " + fromAccount.balance);
        System.out.println("New balance of " + toAccount.accountHolder + ": PHP " + toAccount.balance);
    }

    public void displayAccountDetails(int accountId) {
        Account account = findAccountById(accountId);
        if (account != null) {
            System.out.println("Account ID: " + account.accountId);
            System.out.println("Account Holder: " + account.accountHolder);
            System.out.println("Balance: PHP " + account.balance);
        } else {
            System.out.println("Error: Account not found.");
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (Account account : accounts) {
                System.out.println("Account ID: " + account.accountId + ", Account Holder: " + account.accountHolder + ", Balance: PHP " + account.balance);
            }
        }
    }

    public static void main(String[] args) {
        Transactions app = new Transactions();
        Scanner scanner = new Scanner(System.in);
        int choice;

        app.addAccount(1, "Alice", 5000.0);
        app.addAccount(2, "Bob", 3000.0);

        do {
            System.out.println("\n--- Cash Transfer System Menu ---");
            System.out.println("1. View All Accounts");
            System.out.println("2. View Account Details");
            System.out.println("3. Transfer Funds");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); 
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    app.displayAllAccounts();
                    break;
                case 2:
                    System.out.print("Enter Account ID to view details: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Account ID.");
                        scanner.next(); // Clear the invalid input
                        System.out.print("Enter Account ID to view details: ");
                    }
                    int accountId = scanner.nextInt();
                    app.displayAccountDetails(accountId);
                    break;
                case 3:
                    System.out.print("Enter source account ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Account ID.");
                        scanner.next(); // Clear the invalid input
                        System.out.print("Enter source account ID: ");
                    }
                    int fromAccountId = scanner.nextInt();
                    System.out.print("Enter destination account ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Account ID.");
                        scanner.next(); // Clear the invalid input
                        System.out.print("Enter destination account ID: ");
                    }
                    int toAccountId = scanner.nextInt();
                    System.out.print("Enter amount to transfer: PHP ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next(); // Clear the invalid input
                        System.out.print("Enter amount to transfer: PHP ");
                    }
                    double amount = scanner.nextDouble();
                    app.transferFunds(fromAccountId, toAccountId, amount);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

    }
}
