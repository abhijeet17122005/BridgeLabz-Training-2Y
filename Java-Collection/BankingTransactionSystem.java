import java.util.*;

public class BankingTransactionSystem {
    static class Account {
        final String accountId;
        Account(String id){ accountId=id; }
        @Override public boolean equals(Object o){ return o instanceof Account && ((Account)o).accountId.equals(accountId); }
        @Override public int hashCode(){ return accountId.hashCode(); }
        public String toString(){ return accountId; }
    }

    static class Transaction {
        final String txnId;
        final String accountId;
        final double amount;
        Transaction(String id, String acc, double amt){ txnId=id; accountId=acc; amount=amt; }
        public String toString(){ return txnId + ":" + accountId + ":" + amount; }
    }

    public static void main(String[] args) {
        List<Transaction> allTxns = new ArrayList<>();
        Queue<Transaction> pending = new LinkedList<>();
        Set<Account> validAccounts = new HashSet<>();
        Stack<Transaction> rollbackStack = new Stack<>();

        // Setup accounts
        validAccounts.add(new Account("A1"));
        validAccounts.add(new Account("A2"));

        // Add transactions
        Transaction t1 = new Transaction("T1","A1",100.0);
        Transaction t2 = new Transaction("T2","A3",50.0); // invalid account
        Transaction t3 = new Transaction("T3","A2",75.0);

        pending.add(t1); pending.add(t2); pending.add(t3);

        // Process sequentially
        while (!pending.isEmpty()) {
            Transaction t = pending.poll();
            System.out.println("Processing " + t);
            // validate account
            if (!validAccounts.contains(new Account(t.accountId))) {
                System.out.println(" -> Invalid account " + t.accountId + ", skipped.");
                continue;
            }
            // execute (simulate) and push to rollback stack
            System.out.println(" -> Executed");
            allTxns.add(t);
            rollbackStack.push(t);
        }

        System.out.println("All executed txns: " + allTxns);

        // Rollback last transaction
        if (!rollbackStack.isEmpty()) {
            Transaction last = rollbackStack.pop();
            System.out.println("Rolling back last transaction: " + last);
            allTxns.remove(last);
        }

        System.out.println("Final txn list: " + allTxns);
    }
}
