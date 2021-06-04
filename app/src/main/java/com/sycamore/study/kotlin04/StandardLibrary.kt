package com.sycamore.study.kotlin04

import java.io.File

/**
 * @author dingyx
 * @description: 标准库函数 02
 *
 * apply 配置函数(传入一个接收者，然后调用一系列函数来配置使用)
 * apply 调用函数类配置接收者时，变量名就省掉了。在 lambda 表达式里，apply 能让每个配置函数都作用于接收者。这种行为又叫相关作用域。lambda表达式所有函数调用都是针对接收者(针对接收者的隐式调用)。
 *
 * let 函数可以使某个变量作用于其 lambda 表达式里，让 it 关键字能引用它。
 * let 与 apply 比较，let 会把接收者传给 lambda ，而 apply 什么都不传。
 * apply 会返回当前接收者，而 let 会返回 lambda 最后一行
 * 返回当前接收者，
 *
 * run 函数 作用域行为为与 apply 差不多，但是 run 函数，不返回接收者，返回的是 lambda 结果
 * run 函数 也能用来执行函数引用
 *
 * with 函数 是 run 的变体，与 run 功能行为一致。但是调用方式不同，调用 with 时，需要值参作为其第一个参数传入
 *
 * also 函数 与 let 函数功能相似，把接收者作为值参传给 lambda，但有一点不同：also 返回接收者对象，而 let 返回 lambda 结果。
 * also 是和针对同一原始对象，asl返回的是接收者对象，就可以基于原始接收者对象执行额外的链式调用
 *
 * takeIf 函数 takeIf 需要判断 lambda 中提供的条表达式，给出 true 或者 false 结果，如果是 true 返回接收者对象，如果是 false 则返回 null 。
 * 如果需要判断某个条件是否满足，再决定是否可以赋值变量或者某项任务，就可以使用 takeIf 函数。takeIf类似if语句，但可以直接在对象实例调用。避免临时赋值麻烦
 *
 * takeUnless 只有判断条件为 false 时，返回接收对象，否则返回 null
 *
 * @date: 2021/6/3
 */

fun main() {

    val file = File("D:\\temp\\test.txt")
    //    file.setReadable(true)
    //    file.setWritable(true)
    //    file.setExecutable(false)
    // apply 返回调用者  隐式调用
    val myFile = File("D:\\temp\\test.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    // let 使用 it 关键字调用变量 lambda 表达式结果
    val result = listOf(1, 2, 3, 4).first().let {
        it * it
    }
    println(result)

    println(greet(null))

    // run 函数 隐式调用（类似 apply） 但是返回 lambda 表达式结果
    val txtResult = file.run {
        readText().contains("great")
    }
    println(txtResult)

    // run 执行函数引用  等同isLong("dxy is 24 years old")
    val isLong = "dxy is 24 years old".run(::isLong)
    println(isLong)
    // 使用 run 可以支持链式调用
    "dxy is 24 years old".run(::isLong).run(::showMessage).run(::println)


    // with 函数
    // "dxy is 24 years old".run { length >= 10 }
    val lengthIsLong = with("dxy is 24 years old") { length >= 10 }

    // also 函数 返回接收者对象
    var fileContents: List<String>
    File("D:\\temp\\test.txt").also {
        println(it.name)
    }.also {
        fileContents = it.readLines()
    }
    println(fileContents)


    // takeIf
    val readResult = File("D:\\temp\\test.txt").takeIf {
        it.exists() && it.canRead()
    }?.readText()
    println(readResult)

}

// 使用 let 表达式、空安全操作符
fun greet(name: String?): String {
    return name?.let {
        "Welcome $it"
    } ?: "Welcome You"
}


fun isLong(name: String) = name.length >= 10

fun showMessage(isLong: Boolean): String {
    return if (isLong) {
        "name is too long"
    } else {
        "please rename"
    }
}