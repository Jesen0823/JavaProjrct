package java_design_patterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicAdagent  implements InvocationHandler {

    private Object obj;

    public DynamicAdagent(Object o){
        this.obj = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(obj,args);
        if (method.getName().equals("buy")){
            System.out.println(obj+", buy something.");
        }
        return result;
    }
}
