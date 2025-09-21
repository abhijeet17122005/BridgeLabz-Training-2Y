interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }
    public double calculateInterest() { return getBalance() * 0.04; }
    public void applyForLoan(double amount) { System.out.println("Savings Loan Applied: " + amount); }
    public boolean calculateLoanEligibility() { return getBalance() > 5000; }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }
    public double calculateInterest() { return getBalance() * 0.02; }
    public void applyForLoan(double amount) { System.out.println("Current Loan Applied: " + amount); }
    public boolean calculateLoanEligibility() { return getBalance() > 10000; }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount(111, "John", 10000);
        BankAccount acc2 = new CurrentAccount(222, "Emma", 20000);

        System.out.println(acc1.getHolderName() + " Interest: " + acc1.calculateInterest());
        System.out.println(acc2.getHolderName() + " Interest: " + acc2.calculateInterest());
    }
}
