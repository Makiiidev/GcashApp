package gcashapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashTransfer {

    public void transfer(int senderId, int recipientId, double amount) {
        // Implement cash transfer logic
        System.out.println("Successfully transferred PHP " + amount + " to user " + recipientId);
    }

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

    public static void main(String[] args) {
        CashTransfer app = new CashTransfer();
        Scanner sc = new Scanner(System.in);

        app.addAccount(1, "Alice", 5000.0);
        app.addAccount(2, "Bob", 3000.0);

        System.out.println("Initial Account Details:");
        app.displayAccountDetails(1);
        app.displayAccountDetails(2);

        System.out.print("\nEnter source account ID: ");
        int fromAccountId = sc.nextInt();
        System.out.print("Enter destination account ID: ");
        int toAccountId = sc.nextInt();
        System.out.print("Enter amount to transfer: PHP ");
        double amount = sc.nextDouble();

        app.transferFunds(fromAccountId, toAccountId, amount);

        System.out.println("\nUpdated Account Details:");
        app.displayAccountDetails(1);
        app.displayAccountDetails(2);
    }
}
