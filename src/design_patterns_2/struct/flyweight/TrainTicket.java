package design_patterns_2.struct.flyweight;

import java.util.Random;

public class TrainTicket implements Ticket {
    private String from;
    private String to;
    private String bunk;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showTicketInfo(String bunk) {
        price = new Random().nextInt(300);
        System.out.println(from + " - " + to + " 席别：" + bunk + " 价格：" + price);
    }
}
