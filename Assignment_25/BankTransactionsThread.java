public class BankTransactionsThread {
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
 
    static class DepositThread extends Thread {
        private final BankAccount account;
 
        DepositThread(BankAccount account) {
            super("Deposit-Thread");
            this.account = account;
        }
 
        @Override
        public void run() {
            account.deposit(500, getName());
            account.deposit(200, getName());
        }
    }
 
    static class WithdrawalThread extends Thread {
        private final BankAccount account;
 
        WithdrawalThread(BankAccount account) {
            super("Withdrawal-Thread");
            this.account = account;
        }
 
        @Override
        public void run() {
            account.withdraw(300, getName());
            account.withdraw(250, getName());
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: Rs. " + account.getBalance());
 
        Thread deposit = new DepositThread(account);
        Thread withdrawal = new WithdrawalThread(account);
        deposit.start();
        withdrawal.start();
        deposit.join();
        withdrawal.join();
        System.out.println("Final balance: Rs. " + account.getBalance());
    }
}
