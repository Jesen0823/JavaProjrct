package design_patterns_2.action.chain;

public class Request2 extends AbstractRequest {

    public Request2(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }
}
