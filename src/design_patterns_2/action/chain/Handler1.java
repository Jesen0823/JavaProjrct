package design_patterns_2.action.chain;

public class Handler1 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 1;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("handle: "+getHandleLevel()+", request: "+request.getRequestLevel());
    }
}
