package design_patterns_2.struct.decoration.kt

import design_patterns_2.struct.decoration.jv.SanfangUser

/**
 * 正是由于装饰者是为了扩展功能的目的
 * 所以，kotlin中可以借助高阶函数，拓展类的功能，实现类似Java装饰者模式的功能
 * */
class SanfangUser2 {
    fun login() {
        println("三方账号 准备登录")
    }
}

fun SanfangUser2.withQQ(decorator: () -> Unit) {
    login()
    println("用QQ登录")
    decorator()
}

fun SanfangUser2.withWX(decorator: () -> Unit) {
    login()
    println("用微信登录")
    decorator()
}

fun main() {
    SanfangUser2().run {
        withQQ {
            withWX {

            }
        }
    }
}