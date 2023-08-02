package design_patterns_2.create.singlton

/**
 * kotlin 懒汉模式 线程安全 并发效率低
 * */
class LazySingletonSafeKt private constructor() {
    companion object {
        private var instance: LazySingletonSafeKt? = null
            get() {
                if (field == null) {
                    field = LazySingletonSafeKt()
                }
                return field
            }

        @Synchronized
        fun get(): LazySingletonSafeKt {
            return instance!!
        }
    }
}