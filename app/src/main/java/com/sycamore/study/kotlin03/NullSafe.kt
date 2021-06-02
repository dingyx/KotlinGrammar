package com.sycamore.study.kotlin03

/**
 * @author dingyx
 * @description: null 安全 01
 * Kotlin 更多的把运行时可能会出现的 null 问题，以编译时错误的方式，提前的编译体现出来，避免到运行时报错。
 *
 * Kotlin null安全   [在 Kotlin 中，对于 null 值问题。除非另有规定，否则变量不可为 null 值。]
 *
 * Kotlin null类型  [为了避免NullPointerException，Kotlin 的做法是不允许给非空类型变量赋 null 值。但是 null 在 Kotlin 中依然存在。]
 *
 * Kotlin 区分可空和非空类型  对于可空类型，Kotlin 不允许你在可空类型值上调用函数，除非主动接受安全管理
 *
 * @date: 2021/6/2
 */
fun main() {
    var str = "hello"
    // str = null   [error]

    // 类型String后面加？ 表示可空字符串类型
    var string: String? = "hi"
    string = null
    println(string)
}