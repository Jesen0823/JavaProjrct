package threadcorekonwledge.threadsecurity;
/**
 * 隐士逸出，观察者模式
 * */
public class ListenerHideOverFlow5 {
    int count;

    public static void main(String[] args) {
        Source source = new Source();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                source.eventCome(new Event(){

                });
            }
        }).start();
        // 初始化类
        ListenerHideOverFlow5 listenerHideOverFlow5 = new ListenerHideOverFlow5(source);
    }

    public ListenerHideOverFlow5(Source source){
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.println("\ncount="+count);
            }
        });
        for (int i=0;i<10000;i++){ //模拟耗时其他操作
            System.out.print(i);
        }
        count =100;
    }

    static class Source{
        private EventListener listener;

        void registerListener(EventListener eventListener){
            this.listener = eventListener;
        }

        void eventCome(Event e){
            if (listener != null){
                listener.onEvent(e);
            }else {
                System.out.println("还未初始化.");
            }
        }
    }

}

interface EventListener{
    void onEvent(Event e);
}

class Event{

}
