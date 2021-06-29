package com.sycamore.study.kotlin07

/**
 * @author dingyx
 * @description: 04 reified
 *
 * 有时候，需要知道某个泛型参数具体是什么类型
 * reified 关键字能检查泛型参数类型
 * Kotlin不允许对泛型参数T做类型检查，因为泛型参数类型会被类型擦除，也就是说T的类型信息在运行时是不可知，java也有这样的规则
 *
 * @date: 2021/6/22
 */

open class Human(val age: Int)
class Baby(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Baby(name='$name',age='$age')"
    }
}
class Adult(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Adult(name='$name',age='$age')"
    }
}

class Container<T : Human> {
    // 随机产生一个对象，如果不是指定类型对象，就用过backup函数生成
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val items = listOf(
            Baby("dyx", 3),
            Adult("dingyx", 22)
        )
        val random = items.shuffled().first()
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}

fun main() {
    val container: Container<Baby> = Container()
    val subject =  container.randomOrBackup {
        Baby("dyx", 8)
    }
    println(subject)

}