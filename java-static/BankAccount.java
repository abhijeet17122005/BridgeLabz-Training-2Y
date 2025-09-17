public class BankAccount {
    private static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        // use this to resolve ambiguity
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // final assigned here
        this.balance = initialBalance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String getBankName() {
        return bankName;
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= balance) balance -= amt;
    }

    public void displayDetails(Object obj) {
        // instanceof check before casting/using
        if (obj instanceof BankAccount) {
            System.out.println("Bank: " + BankAccount.bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account No: " + this.accountNumber);
            System.out.println("Balance: " + this.balance);
        } else {
            System.out.println("Provided object is not a BankAccount.");
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Ravi Kumar", "ACC1001", 5000.0);
        BankAccount a2 = new BankAccount("Sita Sharma", "ACC1002", 7500.0);

        a1.deposit(1500);
        a2.withdraw(500);

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        a1.displayDetails(a1);
        a1.displayDetails("not an account");
    }
}
