package javabasereview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解，保存范围是在文件执行阶段,且定义个取值范围
 * */
//@Target(value = ElementType.TYPE)
//@Retention(value = RetentionPolicy.CLASS)
public @interface MyAnnotation {
    Param arg1() default Param.HD;
    Param arg2() default Param.REY_4K;
}
