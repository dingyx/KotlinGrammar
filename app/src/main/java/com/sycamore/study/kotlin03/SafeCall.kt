package com.sycamore.study.kotlin03

/**
 * @author dingyx
 * @description: 安全调用 02
 *
 * 安全调用操作符 ?.
 * 编译器看到有安全调用操作符，所以它知道如何检查 null 值。如果遇到 null 值，直接跳过函数调用，而不是直接返回 null
 *
 * 非空断言操作符 !!. 使用该操作符，当变量为空时，会抛出 NullPointerException
 *
 * 空合并操作符 ?: 如果左边值为 null ，就使用右边的结果
 *
 *
 * @date: 2021/6/2
 */
fun main() {
    var str: String? = "hello"
    str = ""
    // 当 str 为 null 时不调用 capitalize函数
    println(str?.capitalize())

    //   let 函数  当 str 为 空字符串 设置一个默认字符串
    str = str?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "HELLO"
        }
    }
    println(str)

    str = null
    // 非空断言 为空时也执行 抛异常
    //str!!.capitalize()
    // java 判断方式
    if (str != null) {
        println(str.capitalize())
    } else {
        println("str is null")
    }

    // 空合并操作符
    val strWithSafe = str ?: "hi";
    println(strWithSafe)

    // 空合并操作符和 let一起使用
    str = "java"
    str = str?.capitalize()?.plus(" is good!") ?: "str is null"
    println(str)
}