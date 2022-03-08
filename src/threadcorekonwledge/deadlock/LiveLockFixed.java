package threadcorekonwledge.deadlock;

import java.util.Random;

/**
 * 活锁问题
 * */
public class LiveLockFixed {
    static class Spoon{
        private Diner2 owner;

        public Spoon(Diner2 owner) {
            this.owner = owner;
        }

        public Diner2 getOwner() {
            return owner;
        }

        public void setOwner(Diner2 owner) {
            this.owner = owner;
        }

        public synchronized void use(){
            System.out.println(String.format("%s has eat launch", owner.name));
        }
    }

    static class Diner2{
        private String name;
        private boolean isHungry = true;

        public Diner2(String name) {
            this.name = name;
        }

        public void eatWith(Spoon spoon, Diner2 friend){
            while (isHungry){
                if (spoon.owner != this){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Random random = new Random();
                // 如果对方需要吃饭，先让给对方
                if (friend.isHungry && random.nextInt(10) < 7){
                    System.out.println(name+":"+friend.name+" 你先吃");
                    spoon.setOwner(friend);
                    continue;
                }
                spoon.use();
                isHungry = false;
                System.out.println(name+":我吃完了，给你，"+friend.name);
                spoon.setOwner(friend);
            }
        }
    }

    public static void main(String[] args) {
        Diner2 userChen2 = new Diner2("Chen");
        Diner2 userMao2 = new Diner2("Mao");
        Spoon spoon2 = new Spoon(userChen2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                userChen2.eatWith(spoon2,userMao2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                userMao2.eatWith(spoon2,userChen2);
            }
        }).start();
    }
}
