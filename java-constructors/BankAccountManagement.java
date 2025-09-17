public class BankAccountManagement {
    static class BankAccount {
        public String accountNumber;
        
        protected String accountHolder;
        
        private double balance;
        
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
        
        public double getBalance() {
            return balance;
        }
        
        public void setBalance(double amount) {
            if (amount >= 0) {
                this.balance = amount;
                System.out.println("Balance updated to: $" + String.format("%.2f", amount));
            } else {
                System.out.println("Invalid amount! Balance cannot be negative.");
            }
        }
        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + String.format("%.2f", amount) + 
                                 ", New Balance: $" + String.format("%.2f", balance));
            }
        }
        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + String.format("%.2f", amount) + 
                                 ", New Balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds.");
            }
        }
        
        public void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber + " (public access)");
            System.out.println("Account Holder: " + accountHolder + " (protected access)");
            System.out.println("Balance: $" + String.format("%.2f", balance) + " (private - accessed internally)");
        }
    }
    
    static class SavingsAccount extends BankAccount {
        private double interestRate;
        private double minimumBalance;
        
        public SavingsAccount(String accountNumber, String accountHolder, double balance, 
                            double interestRate, double minimumBalance) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
            this.minimumBalance = minimumBalance;
        }
        
        public void displaySavingsAccountInfo() {
            System.out.println("=== Savings Account Details ===");
            System.out.println("Account Number: " + accountNumber + " (public - inherited and accessible)");
            System.out.println("Account Holder: " + accountHolder + " (protected - accessible in subclass)");
            System.out.println("Current Balance: $" + String.format("%.2f", getBalance()) + " (private - accessed via public method)");
            System.out.println("Interest Rate: " + (interestRate * 100) + "%");
            System.out.println("Minimum Balance: $" + String.format("%.2f", minimumBalance));
        }
        
        public void calculateInterest() {
            double currentBalance = getBalance();
            double interest = currentBalance * interestRate;
            System.out.println("Interest earned: $" + String.format("%.2f", interest));
            setBalance(currentBalance + interest);
        }
        
        public boolean checkMinimumBalance() {
            return getBalance() >= minimumBalance;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Bank Account Management ===\n");
        
        BankAccount account1 = new BankAccount("ACC001", "John Doe", 1500.00);
        
        System.out.println("Regular Bank Account:");
        account1.displayAccountInfo();
        System.out.println("Accessing public account number directly: " + account1.accountNumber);
        
        System.out.println("\nPerforming transactions:");
        account1.deposit(500.00);
        account1.withdraw(200.00);
        account1.setBalance(1750.00);
        
        System.out.println("\n" + "=".repeat(50));
        
        SavingsAccount savingsAcc = new SavingsAccount(
            "SAV001", 
            "Jane Smith", 
            2000.00, 
            0.03,
            500.00
        );
        
        savingsAcc.displaySavingsAccountInfo();
        
        System.out.println("\nSavings account operations:");
        savingsAcc.deposit(1000.00);
        System.out.println("Minimum balance requirement met: " + savingsAcc.checkMinimumBalance());
        savingsAcc.calculateInterest();
        savingsAcc.displaySavingsAccountInfo();
        
        System.out.println("\nTesting withdrawal:");
        savingsAcc.withdraw(2500.00);
        System.out.println("After withdrawal - Minimum balance requirement met: " + savingsAcc.checkMinimumBalance());
    }
}