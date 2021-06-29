package com.sycamore.study.kotlin08

import java.io.File

/**
 * @author dingyx
 * @description: 02、DSL
 *
 * 使用这样的编程范式，可以写出业界知名的"领域特定语言"(DSL)，一种API编程范式，暴露接收者的函数和特性，以便于使用你定义的lambda表达式来读取和配置它们
 *
 * 带接收者的函数字面量
 *
 *
 *
 * @date: 2021/6/29
 */

// 匿名函数 fix 无参 返回 string
fun doSomething(fix: () -> String) {

}

// 泛型扩展函数
fun <T> T.myPrint() = println(this)

// apply 参数为 扩展匿名函数(泛型) T.() -> Unit
// 扩展函数自带了接收者对象的this隐式调用
public inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

fun main() {
    File("D:\\temp\\test.txt").apply {
        setReadable(true)
    }
}