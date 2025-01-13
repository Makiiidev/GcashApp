package gcashapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckBalance {

    static class BalanceRecord {
        int id;
        double amount;
        int userId;

        BalanceRecord(int id, double amount, int userId) {
            this.id = id;
            this.amount = amount;
            this.userId = userId;
        }
    }

    private List<BalanceRecord> balanceTable = new ArrayList<>();

    public CheckBalance() {
        // Add dummy data to the simulated database
        balanceTable.add(new BalanceRecord(1, 5000.0, 1));
        balanceTable.add(new BalanceRecord(2, 3000.0, 2));
        balanceTable.add(new BalanceRecord(3, 10000.0, 3));
    }

    public void checkBalance(int userId) {
        for (BalanceRecord record : balanceTable) {
            if (record.userId == userId) {
                System.out.println("Your current balance is: PHP " + record.amount);
                return;
            }
        }
        System.out.println("Error: User ID not found.");
    }

    public void CheckBalance(int userId) {
        // Implement balance checking logic
        System.out.println("Your current balance is: PHP 0.00");
    }

    public static void main(String[] args) {
        CheckBalance app = new CheckBalance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your User ID to check balance: ");
        int userId = scanner.nextInt();

        app.checkBalance(userId);
    }

   
}
