package com.sycamore.study.kotlin07


/**
 * @author dingyx
 * @description: 02 泛型
 *
 * 定义泛型类
 * 泛型类的构造函数可以接受任何类型
 * 泛型参数由一对 <> 里的字母 通常用 T 表示，T 是个代表 item 类型的占位符。
 * 表示可以接受任何类型的 item 作为主构造函数值(item:T)
 *
 * 泛型函数   定义一个函数用于获取元素
 *
 * 多泛型参数    泛型函数或泛型类也可以有多个泛型参数
 *
 * 泛型类型约束 class MagicBox<T : Human>(item: T) {
 *
 * vararg 关键字 可变参数   放多个实例 class MagicBox<T : Human>(vararg item: T) {
 *
 * @date: 2021/6/19
 */
class MagicBox<T>(item: T) {

    var available = false

    private var subject: T = item

    // 泛型函数
    fun fetch(): T? {
        // takeIf true 返回接收者 false 返回空
        return subject.takeIf { available }
    }

    // 传入一个匿名函数，参数 T 返回 R
    // fetch 函数 返回 R?
    fun <R> fetch(subjectModFunction: (T) -> (R)): R? {
        return subjectModFunction(subject).takeIf { available }
    }

}


// vararg 关键字 可变参数   放多个实例
class Animal<T>(vararg item: T) {

    // 可变参数与泛型结合 Array<out T>
    private var subject: Array<out T> = item

    fun fetch(index: Int): T? {
        return subject[index]
    }

}


class Boy(val name: String, val age: Int)

class Dog(val weight: Int)

class Man(val name: String, val age: Int)

fun main() {
    val magicBox1: MagicBox<Boy> = MagicBox(Boy("dyx", 24))
    val magicBox2: MagicBox<Dog> = MagicBox(Dog(16))

    magicBox1.available = true
    magicBox1.fetch()?.run {
        println("you find $name")
    }

    val man = magicBox1.fetch {
        Man(it.name, it.age.plus(18))
    }

}