package design_patterns_2.action.chain;
/**
 * 责任链模式
 * 多个对象可以处理同一请求，具体由哪个对象处理则在运行时决定
 * */
public class ChainTest {
    public static void main(String[] args) {
        AbstractHandler handler1 = new Handler1();
        AbstractHandler handler2 = new Handler2();
        handler1.nextHandler = handler2;

        AbstractRequest request1 = new Request1("Q1");
        AbstractRequest request2 = new Request2("Q2");
        AbstractRequest request3 = new Request3("Q3");

        handler1.handleRequest(request1);
        handler2.handleRequest(request2);
    }
}
