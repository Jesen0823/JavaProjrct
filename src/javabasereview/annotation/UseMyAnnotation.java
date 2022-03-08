package javabasereview.annotation;

public class UseMyAnnotation {

    @SuppressWarnings("uncheck")
    @MyAnnotation(arg1 = Param.HDR, arg2 = Param.HDR)
    public String doSomething(){
        return "the method use annotation.";
    }
}
