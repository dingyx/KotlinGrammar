package com.sycamore.study.kotlin01

/**
 * @author dingyx
 * @description: string 模版
 * 字符串引号内放入变量值和表达式
 *
 * @date: 2021/6/1
 */

fun main() {

    val origin = "武汉"
    val dest = "深圳"
    println("$origin TO $dest")

    val flag = true
    println("Answer is ${if (flag) "YES" else "NO"}")

}