package com.sycamore.study.kotlin06

/**
 * @author dingyx
 * @description: field 01
 * 对于定义的每一个属性 ， kotlin 都会生成一个 filed、getter、setter。
 * field 用来存储属性数据  不能直接定义 field，Kotlin 会封装 filed ，提供 getter、setter 方法。只有可变属性才有 setter 方法。
 * 在需要控住如何读写属性时，也可以自定义 getter、setter。
 * (为了更好的实现空安全，Kotlin 生成 getter、setter 方法根据定义是否可空在setter方法时就进行检测)
 * @date: 2021/6/8
 */
class FieldStudy {

    // 自动生成 getter、setter 方法 Show Kotlin Bytecode
    var name = "dyx"


    var str = "                d y x "
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }


    // 计算属性 通过 覆盖 get、set 运算符定义 (覆盖 get set 不一定需要 field)
    val value
        get() = (1..6).shuffled().first()


}

fun main() {
    var fieldStudy = FieldStudy()
    // fileStudy.setName("DYX")
    fieldStudy.name = "DYX"
    fieldStudy.str = "                d y x "
    println(fieldStudy.str)

}