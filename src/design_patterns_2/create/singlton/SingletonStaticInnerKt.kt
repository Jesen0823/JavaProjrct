package design_patterns_2.create.singlton
/**
 * kotlin 静态内部类  线程安全
 * */
class SingletonStaticInnerKt private constructor(){

    companion object{
        val instance:SingletonStaticInnerKt = SingletonProvider.holder
    }

    private object SingletonProvider{
        val holder = SingletonStaticInnerKt()
    }
}