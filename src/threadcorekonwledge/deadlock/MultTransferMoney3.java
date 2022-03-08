package threadcorekonwledge.deadlock;

import java.util.Random;

/**
 * 多人银行转账,随着交易量增大，会循环等待，依然会发生死锁
 * */
public class MultTransferMoney3 implements Runnable{

    private static final int NUM_ACCOUNTS = 500;
    private static final int NUM_MONEY = 1000;
    private static final int NUM_ITERATIONS = 1000000;
    private static final int NUM_THREAD = 20;

    private int flag;
    // a,b都是初始拥有500金额的账户
    static Account a = new Account(500);
    static Account b = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        Random rnd  = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];
        // 初始化500个账户
        for (int i = 0; i < accounts.length; i++){
            accounts[i] = new Account(NUM_MONEY);
        }


        class TransferThread extends Thread{

            @Override
            public void run() {
                for (int i =0; i < NUM_ITERATIONS; i++){
                    // 随机挑选两个账户准备转账
                    int from = rnd.nextInt(NUM_ACCOUNTS);
                    int to  = rnd.nextInt(NUM_ACCOUNTS);
                    int amount = rnd.nextInt(NUM_MONEY);
                    transfer(accounts[from],accounts[to], amount);
                }
            }
        }
        for (int j =0; j < NUM_THREAD; j++){
            new TransferThread().start();
        }
    }

    @Override
    public void run() {
        if (flag == 1){
            transfer(a, b, 200);
        }
        if (flag == 0){
            transfer(b, a, 200);
        }
    }

    public static void transfer(Account fromAccount,Account toAccount, int amount){
        synchronized (fromAccount){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (toAccount){
                if (fromAccount.balance - amount < 0){
                    System.out.println("余额不足转账失败");
                }
                fromAccount.balance -= amount;
                toAccount.balance += amount;
                System.out.println("成功转账金额："+amount);
            }
        }
    }

    static class Account{
        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }
}
