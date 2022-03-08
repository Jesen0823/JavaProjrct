package threadcorekonwledge.propertyofthread_and_exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义UncaughtExceptionHandler
 * */
public class MyUncaughtExceptionHandler3 implements Thread.UncaughtExceptionHandler {

    String handlerName;

    public MyUncaughtExceptionHandler3(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，线程终止"+t.getName(),e);
        System.out.println(handlerName+"捕获到异常在"+t.getName()+", e:"+e);
    }
}
