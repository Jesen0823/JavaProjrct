package design_patterns_2.action.chain;

public abstract class AbstractHandler {
    protected AbstractHandler nextHandler;

    public final void handleRequest(AbstractRequest request){
        // 请求和处理的级别一致才处理，否则找下一个
        if (getHandleLevel() == request.getRequestLevel()){
            handle(request);
        }else {
            if (nextHandler !=null){
                nextHandler.handleRequest(request);
            }else {
                throw new UnsupportedOperationException("All of handler cant not handle the request.");
            }
        }
    }

    protected abstract int getHandleLevel();

    protected abstract void handle(AbstractRequest request);
}
