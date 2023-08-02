package design_patterns_2.create.singlton

/**
 * kotlin 懒汉模式  线程不安全
 * */
class LazySingletonKt private constructor() {
    companion object {
        private var instance: LazySingletonKt? = null
            get() {
                if (field == null) {
                    field = LazySingletonKt()
                }
                return field
            }

        fun get(): LazySingletonKt {
            return instance!!
        }
    }
}