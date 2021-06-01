package com.sycamore.study.kotlin01

/**
 * @author dingyx
 * @description: 表达式
 * if/else
 * range  in、!in
 * when (java switch) if else 可以使用when表达式代替
 * @date: 2021/5/31
 */
fun main() {
    val age = 6
    if (age in 0..18) {
        println("少年")
    } else if (age in 18..60) {
        println("中年")
    } else {
        println("老年")
    }


    val city = ""
    val country: Any = when (city) {
        "北京" -> "中国"
        "东京" -> "日本"
        "首尔" -> "韩国"
        else -> {
            println("未知")
        }
    }
    println(country)

}