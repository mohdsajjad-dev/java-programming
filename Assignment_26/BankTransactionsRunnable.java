public class BankTransactionsRunnable {
    static class BankAccount {
        private int balance = 1000;
 
        synchronized void deposit(int amount, String threadName) {
            balance += amount;
            System.out.println(threadName + " deposited Rs. " + amount
                    + " | Balance: Rs. " + balance);
        }
 
        synchronized void withdraw(int amount, String threadName) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(threadName + " withdrew Rs. " + amount
                        + " | Balance: Rs. " + balance);
            } else {
                System.out.println(threadName + " withdrawal failed: insufficient balance.");
            }
        }
 
        synchronized int getBalance() {
            return balance;
        }
    }
 
    static class DepositTask implements Runnable {
        private final BankAccount account;
 
        DepositTask(BankAccount account) {
            this.account = account;
        }
 
        @Override
        public void run() {
            account.deposit(500, Thread.currentThread().getName());
            account.deposit(200, Thread.currentThread().getName());
        }
    }
 
    static class WithdrawalTask implements Runnable {
        private final BankAccount account;
 
        WithdrawalTask(BankAccount account) {
            this.account = account;
        }
 
        @Override
        public void run() {
            account.withdraw(300, Thread.currentThread().getName());
            account.withdraw(250, Thread.currentThread().getName());
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: Rs. " + account.getBalance());
 
        Thread deposit = new Thread(new DepositTask(account), "Deposit-Thread");
        Thread withdrawal = new Thread(new WithdrawalTask(account), "Withdrawal-Thread");
        deposit.start();
        withdrawal.start();
        deposit.join();
        withdrawal.join();
        System.out.println("Final balance: Rs. " + account.getBalance());
    }
}
