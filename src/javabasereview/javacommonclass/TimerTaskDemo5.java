package javabasereview.javacommonclass;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo5 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        PrintTask printTask = new PrintTask();
        timer.schedule(printTask,1000,2000);
    }


}
class PrintTask extends TimerTask{

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}