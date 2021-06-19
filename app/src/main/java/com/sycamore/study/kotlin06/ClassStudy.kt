package com.sycamore.study.kotlin06

/**
 * @author dingyx
 *
 * 解构声明 07
 *
 * 运算符重载
 *
 *  += plusAssign
 *  == equals
 *  > compareTo
 *  [] get
 *  .. rangeTo
 *  in contains
 *
 *
 * @date: 2021/6/11
 */

// 嵌套类
class NestClass {

    // 内部类
    class Inner(var str: String) {
        fun show() = println("str:$str")
    }

}


// 数据类
data class Person(var name: String, var age: Int) {
    val isAdult = age >= 18


}

// 普通类实现解构语法
class Student(val name: String, val age: Int) {
    // 解构声明
    operator fun component1() = name
    operator fun component2() = age
}

// 运算符重载
data class Coordinate(var x: Int, var y: Int) {


    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)


}


fun main() {
    NestClass.Inner("dyx").show()

    println(Person("dyx", 18))

    // == 比较内容 equals |   Any == 默认比较的是引用 也就是 ===  data数据类型重写了 equals 方法
    // === 比较引用
    println(Person("dyx", 18) == Person("dyx", 18))

    // copy 函数 方便复制对象 可以直接传入需要修改参数
    val copyPerson = Person("dyx", 24).copy(name = "dingyx")
    println(copyPerson)

    // 解构
    val (x, y) = Student("dyx", 18)
    println("x:$x   y:$y")
    val (name, age) = Person("dyx", 18)
    println("name:$name  age:$age")


    val coordinate1 = Coordinate(11, 12)
    val coordinate2 = Coordinate(22, 33)
    println(coordinate1 + coordinate2)

}



