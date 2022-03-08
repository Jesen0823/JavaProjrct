package threadcorekonwledge.threadsecurity;
/**
 * 隐士逸出，观察者模式,用工厂模式修复
 * */
public class ListenerHideOverFlowFixed5 {
    int count;
    private EventListenerFixed listenerFixed;

    private ListenerHideOverFlowFixed5(SourceFixed source){
        listenerFixed = new EventListenerFixed() {
            @Override
            public void onEvent(EventFixed e) {
                System.out.println("\ncount="+count);
            }
        };
        for (int i=0;i<10000;i++){ //模拟耗时其他操作
            System.out.print(i);
        }
        count =100;
    }

    /* 工厂方法 */
    public static ListenerHideOverFlowFixed5 getInstance(SourceFixed source){
        ListenerHideOverFlowFixed5 safeInstance = new ListenerHideOverFlowFixed5(source);
        source.registerListener(safeInstance.listenerFixed);
        return safeInstance;
    }

    static class SourceFixed{
        private EventListenerFixed listener;

        void registerListener(EventListenerFixed eventListener){
            this.listener = eventListener;
        }

        void eventCome(EventFixed e){
            if (listener != null){
                listener.onEvent(e);
            }else {
                System.out.println("\n还未初始化.");
            }
        }
    }

    public static void main(String[] args) {
        SourceFixed source = new SourceFixed();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                source.eventCome(new EventFixed(){

                });
            }
        }).start();
        // 初始化类
        ListenerHideOverFlowFixed5 listenerHideOverFlow5 = getInstance(source);
    }

}

interface EventListenerFixed{
    void onEvent(EventFixed e);
}

class EventFixed{

}
