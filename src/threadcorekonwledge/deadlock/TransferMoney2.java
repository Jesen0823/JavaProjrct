package threadcorekonwledge.deadlock;
/**
 * 银行转账
 * */
public class TransferMoney2 implements Runnable{

    private int flag;
    // a,b都是初始拥有500金额的账户
    static Account a = new Account(500);
    static Account b = new Account(500);

    public static void main(String[] args) throws InterruptedException {
        TransferMoney2 r1 = new TransferMoney2();
        TransferMoney2 r2 = new TransferMoney2();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额："+a.balance);
        System.out.println("b的余额："+b.balance);
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

    public static void transfer(Account from,Account to, int amount){
        synchronized (from){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to){
                if (from.balance - amount < 0){
                    System.out.println("余额不足转账失败");
                }
                from.balance -= amount;
                to.balance += amount;
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
