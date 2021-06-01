package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 函数 01
 * private fun doSomeThing(boolean flag):String
 *
 * 默认值参：函数如果不打算传入值，可以指定默认参数值 declare
 * 具名函数参数：使用命名值参，可以不用管顺序
 *
 * Unit函数 kotlin中没有返回值的函数  java中没有返回值时void描述- -void无法解释泛型的特性
 *      Nothing 类型  TODO函数的任务就是抛出异常，返回Noting类型
 *
 * 反引号中的函数名
 *      Kotlin 可以使用空格和特殊字符对函数命名，但是函数名需要用反引号括起来 (Android中不允许特殊字符)
 *      Java和Kotlin各有不同关键字，避免冲突可以在调用时将函数名``括起来
 *
 * @date: 2021/6/1
 */
fun main() {
    println(add(3, 7))
    println(declare("dyx", 22))
    println(define(age = 24, name = "dyx"))
    println(fix("dyx"))
    functionWitSymbol()
    TODO("noting")
    println("after nothing")
}

private fun add(a: Int, b: Int): Int {
    return a + b;
}

private fun declare(name: String, age: Int = 2): String {
    return "$name and $age"
}

private fun define(name: String, age: Int): String {
    return "$name and $age"

}

fun fix(name: String) {
    println(name)
}

fun `functionWitSymbol`() {
    println("WitSymbol")
}