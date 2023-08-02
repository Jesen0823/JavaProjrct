package design_patterns_2.create.builder.jv

/**
 * 建造者模式 kotlin 借助语言特性
 * */
class PaintKt {
    var color = "red"
    var stroke = 1f
    var round = false

    fun draw() {
        println("画笔 $color 色，粗细 $stroke px, 是否用圆角？$round")
    }
}

fun main() {
    val paint = PaintKt()
    with(paint) {
        color = "黄"
        stroke = 3f
        round = true
    }
    paint.draw()
}