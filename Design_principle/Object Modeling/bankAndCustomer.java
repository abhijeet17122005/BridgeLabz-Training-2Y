import java.util.ArrayList;

// Customer class
class Customer {
    String name;
    ArrayList<Account> accounts;  // A customer can have multiple accounts

    // Constructor
    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // View all account balances
    void viewBalance() {
        System.out.println("Customer: " + name + " - Account Balances:");
        for (Account acc : accounts) {
            System.out.println("Account No: " + acc.accountNumber + ", Balance: " + acc.balance);
        }
        System.out.println();
    }
}

// Account class
class Account {
    int accountNumber;
    double balance;
    Bank bank;  // Each account is linked to a Bank

    // Constructor
    Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }
}

// Bank class
class Bank {
    String name;
    ArrayList<Customer> customers;

    // Constructor
    Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Open an account for a customer
    void openAccount(Customer customer, int accNo, double initialDeposit) {
        Account newAccount = new Account(accNo, initialDeposit, this); // Linked with this bank
        customer.accounts.add(newAccount); // Add account to customer
        if (!customers.contains(customer)) {
            customers.add(customer); // Add customer to bank if not already added
        }
        System.out.println("Account opened for " + customer.name + " in " + name + " with Account No: " + accNo);
    }

    // Show all customers
    void showCustomers() {
        System.out.println("Bank: " + name + " has customers:");
        for (Customer c : customers) {
            System.out.println("- " + c.name);
        }
        System.out.println();
    }
}

// Main class to demonstrate association
public class AssociationDemo {
    public static void main(String[] args) {
        // Create a bank
        Bank bank1 = new Bank("State Bank");

        // Create customers
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        // Open accounts (Bank ↔ Customer association)
        bank1.openAccount(c1, 101, 5000);
        bank1.openAccount(c1, 102, 10000);
        bank1.openAccount(c2, 201, 7000);

        // Show bank customers
        bank1.showCustomers();

        // Customers check balance
        c1.viewBalance();
        c2.viewBalance();
    }
}
