package com.sycamore.study.kotlin03


/**
 * @author dingyx
 * @description: 异常、先决条件函数 03
 *
 * 异常捕获、自定义、抛出方式与 java 基本一致
 *
 * Kotlin 标准库提供了便利的内置函数，使用这些函数(先决条件函数)，可以抛出带自定义信息的异常。条件目标满足，目标代码才能执行。
 * checkNotNull 参数为 null，抛出 IllegalStateException 异常，否则返回非 null 值
 * require 参数为 false。抛出 IllegalArgumentException 异常
 * requireNotNul 参数为 null，抛出 IllegalStateException 异常，否则返回非 null 值
 * error 参数为 null，抛出 IllegalStateException 异常并输出错误信息，否则返回非 null 值
 * assert  参数为 false。抛出 AssertError 异常，并打上断言编译器标记
 * @date: 2021/6/2
 */
fun main() {

    // 捕获异常
    try {
        var num: Int? = null
        num!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    checkOperate(1)

    var str: String? = null
    checkNotNull(str, { "str is null !!!" })
}

fun checkOperate(number: Int?) {
    // null 时抛出自定义异常
    number ?: throw DefinedException()
}

// 自定义异常
class DefinedException() : IllegalArgumentException("程序出现异常了！！！") {

}