package com.sycamore.study.kotlin07

/**
 * @author dingyx
 * @description: 01 接口、抽象类
 *
 * Kotlin 规定所有的接口属性和函数都要使用 override 关键字，接口中定义的函数并不需要 open 关键字修饰，他们默认就是open 的
 * 接口里可以提供默认属性的 getter 方法和函数实现
 *
 * 抽象类 使用 abstract ，除了具体的函数实现，抽象类也可以包含抽象函数
 *
 * @date: 2021/6/19
 */
interface Moveable {

    // val maxSpeed: Int = (1..500).shuffled().first()
    val maxSpeed: Int
        get() = (1..500).shuffled().first()

    var wheels: Int
    fun move(movable: Moveable): String

}

class Car(_name: String, override var wheels: Int) : Moveable {
    // 子类继承后 可以修改 var、val属性
    override var maxSpeed: Int
        get() = super.maxSpeed
        set(value) {}

    override fun move(movable: Moveable): String {
        return if (maxSpeed > 0 && wheels > 0) "go go go " else "can not"
    }
}

// 抽象类
abstract class Gun(val range: Int) {
    abstract fun pullTrigger(): String

    protected fun doSomething() {

    }
}

class AK47(val price: Int) : Gun(range = 500) {
    override fun pullTrigger(): String {
        TODO("Not yet implemented")
    }

}


fun main() {

}