package threadcorekonwledge.deadlock;
/**
 * 活锁问题
 * */
public class LiveLock {
    static class Spoon{
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public synchronized void use(){
            System.out.println(String.format("%s has eat launch", owner.name));
        }
    }

    static class Diner{
        private String name;
        private boolean isHungry = true;

        public Diner(String name) {
            this.name = name;
        }

        public void eatWith(Spoon spoon, Diner friend){
            while (isHungry){
                if (spoon.owner != this){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                // 如果对方需要吃饭，先让给对方
                if (friend.isHungry){
                    System.out.println(name+":"+friend.name+"你先吃");
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
        Diner userChen = new Diner("Chen");
        Diner userMao = new Diner("Mao");
        Spoon spoon = new Spoon(userChen);
        new Thread(new Runnable() {
            @Override
            public void run() {
                userChen.eatWith(spoon,userMao);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                userMao.eatWith(spoon,userChen);
            }
        }).start();
    }
}
