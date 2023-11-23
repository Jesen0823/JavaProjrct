package design_patterns_2.action.chain;

public abstract class AbstractRequest {
    private Object obj;// 处理对象

    public AbstractRequest(Object obj){
        this.obj = obj;
    }

    public Object getContent(){
        return obj;
    }

    public abstract int getRequestLevel();
}
