package threadcorekonwledge.deadlock;
/**
 * 银行转账,死锁修复利用其他标志，比如hashcode的大小来确定获取锁的顺序
 * */
public class TransferMoney2Fixed implements Runnable{

    private int flag;
    // a,b都是初始拥有500金额的账户
    static Account a = new Account(500);
    static Account b = new Account(500);
    static Object o =new Object(); //额外的锁，如果hashCode不幸一样大，就让两个线程抢这把锁
    public static void main(String[] args) throws InterruptedException {
        TransferMoney2Fixed r1 = new TransferMoney2Fixed();
        TransferMoney2Fixed r2 = new TransferMoney2Fixed();
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
        class Helper{
            public void transf(){
                if (from.balance - amount < 0){
                    System.out.println("余额不足转账失败");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账金额："+amount);
            }
        }
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        Account firstGetLock = null;
        Account lastGetLock = null;
        if (fromHash < toHash){
            firstGetLock = from;
            lastGetLock = to;
        }else if(fromHash > toHash){
            firstGetLock = to;
            lastGetLock = from;
        }
        if (firstGetLock != null && lastGetLock != null) {
            synchronized (firstGetLock) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lastGetLock) {
                    new Helper().transf();
                }
            }
        }

        if (fromHash == toHash){
            synchronized (o){
                synchronized (from){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (to){
                        new Helper().transf();
                    }
                }
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
