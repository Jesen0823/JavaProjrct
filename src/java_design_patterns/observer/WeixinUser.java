package java_design_patterns.observer;

/**
 * 具体的观察者
 * */
public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(String name){
        this.name = name;
    }

    @Override
    public void update(String msg) {
        showMesssage(msg);
    }

    // 业务方法
    private void showMesssage(String msg) {
        System.out.println(String.format("用户[%s]展示消息：%s", name,msg));
    }
}
