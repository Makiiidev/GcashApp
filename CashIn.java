import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CashIn {

    static class Transaction {
        int id;
        double amount;
        String name;
        int accountId;
        String date;
        Integer transferToId; 
        Integer transferFromId; 

        Transaction(int id, double amount, String name, int accountId, String date, Integer transferToId, Integer transferFromId) {
            this.id = id;
            this.amount = amount;
            this.name = name;
            this.accountId = accountId;
            this.date = date;
            this.transferToId = transferToId;
            this.transferFromId = transferFromId;
        }

        @Override
        public String toString() {
            return "Transaction ID: " + id + ", Amount: PHP " + amount + ", Account ID: " + accountId + ", Date: " + date;
        }
    }

    private List<Transaction> transactionTable = new ArrayList<>();
    private double currentBalance = 0.0;

    public void cashIn(double amount, String name, int accountId) {
        int id = transactionTable.size() + 1; // 
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Transaction transaction = new Transaction(id, amount, name, accountId, date, null, null);
        transactionTable.add(transaction);
        currentBalance += amount;

        System.out.println("Transaction successful!");
        System.out.println(transaction);
        System.out.println("New Balance: PHP " + currentBalance);
    }

    public static void main(String[] args) {
        CashIn app = new CashIn();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Account ID: ");
        int accountId = scanner.nextInt();

        System.out.print("Enter your Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter amount to cash in: PHP ");
        double amount = scanner.nextDouble();

        app.cashIn(amount, name, accountId);

        System.out.print("Enter another amount to cash in: PHP ");
        amount = scanner.nextDouble();
        app.cashIn(amount, name, accountId);
    }
}
