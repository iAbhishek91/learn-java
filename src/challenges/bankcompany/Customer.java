package challenges.bankcompany;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Customer {
    private final String firstName;
    private final String lastName;
    private Double balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, 0.0d);
    }
    public Customer(String firstName, String lastName, Double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void checkBalance() {
        System.out.println("Fetching balance...");
        System.out.println("Available balance: " + this.balance);
        System.out.println("----------------------------");
    }

    public void viewProfile() {
        System.out.println("Fetching profile...");
        System.out.println("First Name: " + this.firstName + "; Last Name: " + this.lastName);
        System.out.println("----------------------------");
    }

    public void showTransactions() {
        System.out.println("Fetching transactions....");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for(Transaction transaction:this.transactions){
            System.out.println(formatter.format(transaction.getTimeStamp())+ " | " + transaction.getTransactionType() + " | " + transaction.getAmount() + " | " + transaction.getTransctionDescription());
        }
        System.out.println("----------------------------");
    }

    public void withdraw(double amount, String description) {
        if (this.balance < amount) {
            System.out.println("Err: Insufficient balance!");
            this.checkBalance();
            return;
        }
        this.balance -= amount;
        Transaction transaction = new Transaction("DEBIT", amount, description);
        transactions.add(transaction);
        System.out.println("Withdraw successful!");
    }

    public void deposit(double amount, String description) {
        this.balance += amount;
        Transaction transaction = new Transaction("CREDIT", amount, description);
        transactions.add(transaction);
        System.out.println("Deposit successful!");
    }
}
