package design_patterns_2.create.singlton

/**
 * kotlin 双重校验 线程安全
 * */
class SingletonDCLKt private constructor(){

    companion object{
        val instance:SingletonDCLKt by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDCLKt()
        }
    }
}