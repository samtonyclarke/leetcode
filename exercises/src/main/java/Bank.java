import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

class Bank {

    public static void main(String args[]) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        bank.withdraw(3, 10);
        bank.transfer(5, 1, 20);
        bank.deposit(5, 20);
        bank.transfer(3, 4, 15);
        bank.withdraw(10, 50);
        bank.mergeAccounts(3, 4);  // Merge account 3 and 4
        System.out.println("Top 10 accounts by transfer amount:");
        bank.getTop10Accounts().forEach(account -> System.out.println(account));
    }

    private final Account[] accounts;
    private final PriorityQueue<Account> topAccounts;

    public Bank(long[] balance) {
        this.accounts = new Account[balance.length];
        for (int i = 0; i < balance.length; i++) {
            accounts[i] = new Account(balance[i], i + 1); // Account IDs are 1-based
        }
        // Create a max-heap (PriorityQueue) based on account transfer history
        topAccounts = new PriorityQueue<>((a, b) -> Long.compare(b.getTotalTransferAmount(), a.getTotalTransferAmount()));
    }

    public boolean transfer(int fromAccount, int toAccount, long money) {
        if (!validateAccount(fromAccount) || !(validateAccount(toAccount)) || money < 0) return false;

        Account from = getAccount(fromAccount);
        Account to = getAccount(toAccount);

        try {
            if (from.lock.tryLock(1, SECONDS)) {
                try {
                    if (to.lock.tryLock(1, SECONDS)) {
                        try {
                            if (from.withdraw(money)) {
                                if (to.deposit(money)) {
                                    // Add transaction history for both accounts
                                    from.addTransaction(
                                            new Transaction(Transaction.TransactionType.WITHDRAWAL, money, fromAccount));
                                    to.addTransaction(
                                            new Transaction(Transaction.TransactionType.DEPOSIT, money, toAccount));
                                    // Update max heap after transfer
                                    updateTopAccounts(from);
                                    updateTopAccounts(to);
                                } else {
                                    // If deposit fails, roll back the withdrawal
                                    from.deposit(money); // Rollback the withdrawal
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } finally {
                            to.lock.unlock();
                        }
                    }
                } finally {
                    from.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return true;
    }

    public boolean deposit(int account, long money) {
        if (!validateAccount(account)) return false;
        boolean result = getAccount(account).deposit(money);
        if (result) {
            getAccount(account).addTransaction(new Transaction(Transaction.TransactionType.DEPOSIT, money, account));
            updateTopAccounts(getAccount(account));
        }
        return result;
    }

    public boolean withdraw(int account, long money) {
        if (!validateAccount(account)) return false;
        boolean result = getAccount(account).withdraw(money);
        if (result) {
            getAccount(account).addTransaction(new Transaction(Transaction.TransactionType.WITHDRAWAL, money, account));
            updateTopAccounts(getAccount(account));
        }
        return result;
    }

    public boolean mergeAccounts(int fromAccount, int toAccount) {
        if (!validateAccount(fromAccount) || !(validateAccount(toAccount))) return false;

        Account from = getAccount(fromAccount);
        Account to = getAccount(toAccount);

        try {
            if (from.lock.tryLock(1, SECONDS)) {
                try {
                    if (to.lock.tryLock(1, SECONDS)) {
                        try {
                            // Merge balances: add fromAccount balance to toAccount
                            to.deposit(from.getBalance());  // Deposit from 'from' account to 'to' account
                            // Record merge transactions
                            from.addTransaction(new Transaction(Transaction.TransactionType.MERGE, from.getBalance(), toAccount));
                            to.addTransaction(new Transaction(Transaction.TransactionType.MERGE, from.getBalance(), fromAccount));
                            // Set 'from' account balance to 0 or mark it inactive
                            from.setBalance(0);  // or you could disable the account in another way, e.g., set it to null

                            // Update the max-heap after merging
                            updateTopAccounts(to);
                            return true;
                        } finally {
                            to.lock.unlock();
                        }
                    }
                } finally {
                    from.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return false;
    }

    // Update top accounts in the priority queue based on the account's total transfer amount
    private void updateTopAccounts(Account account) {
        if (topAccounts.contains(account)) {
            topAccounts.remove(account);
        }
        topAccounts.offer(account);

        // Ensure only the top 10 accounts are kept
        if (topAccounts.size() > 10) {
            topAccounts.poll();
        }
    }

    // Retrieve the top 10 accounts based on transfer amount
    public List<Account> getTop10Accounts() {
        List<Account> topAccountsList = new ArrayList<>(topAccounts);
        topAccountsList.sort((a, b) -> Long.compare(b.getTotalTransferAmount(), a.getTotalTransferAmount()));
        return topAccountsList;
    }

    private boolean validateAccount(int account) {
        return account > 0 && account <= accounts.length;
    }

    private Account getAccount(int account) {
        return accounts[account - 1];
    }

    // Nested Transaction class
    public static class Transaction {
        private final TransactionType type;
        private final long amount;
        private final int involvedAccount;
        private final long timestamp;

        public enum TransactionType {
            DEPOSIT,
            WITHDRAWAL,
            MERGE
        }

        public Transaction(TransactionType type, long amount, int involvedAccount) {
            this.type = type;
            this.amount = amount;
            this.involvedAccount = involvedAccount;
            this.timestamp = System.currentTimeMillis();
        }

        public TransactionType getType() {
            return type;
        }

        public long getAmount() {
            return amount;
        }

        public int getInvolvedAccount() {
            return involvedAccount;
        }

        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "type=" + type +
                    ", amount=" + amount +
                    ", involvedAccount=" + involvedAccount +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }

    private static class Account {
        private long balance;
        private long totalTransferAmount = 0;  // Keep track of transfer amounts efficiently
        private final Lock lock = new ReentrantLock(true);
        private final List<Transaction> transactionHistory = new ArrayList<>();
        private final int accountId;

        public Account(long balance, int accountId) {
            this.balance = balance;
            this.accountId = accountId;
        }

        public boolean deposit(long amount) {
            try {
                if (lock.tryLock(1, SECONDS)) {
                    try {
                        balance += amount;
                        totalTransferAmount += amount;  // Update running total of transfers
                    } finally {
                        lock.unlock();
                    }
                    return true;
                }
            } catch (InterruptedException e) {
                return false;
            }
            return false;
        }

        public boolean withdraw(long amount) {
            try {
                if (lock.tryLock(1, SECONDS)) {
                    try {
                        if (balance < amount) return false;
                        balance -= amount;
                        totalTransferAmount += amount;  // Update running total of transfers
                    } finally {
                        lock.unlock();
                    }
                    return true;
                }
            } catch (InterruptedException e) {
                return false;
            }
            return false;
        }

        // Return total transfer amount directly
        public long getTotalTransferAmount() {
            return totalTransferAmount;
        }

        // Add the transaction to history
        public void addTransaction(Transaction transaction) {
            transactionHistory.add(transaction);
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public long getBalance() {
            return balance;
        }
    }

}
