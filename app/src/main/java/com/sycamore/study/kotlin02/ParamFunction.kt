package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 定义参数是函数的函数 03
 *
 *
 * @date: 2021/6/1
 */

fun main() {
    val infoWords = { year: Int, discount: Int ->
        "${year}年${discount}折"
    }
    // 调用 showDiscountInfo 第二个参数是一个函数 函数定义为 infoWords 是一个匿名函数
    showDiscountInfo("iMac", infoWords)

}

/**
 * showDiscountInfo 第二个参数为一个函数
 */
fun showDiscountInfo(goods: String, info: (Int, Int) -> String) {
    val year: Int = (2010..2021).shuffled().last()
    println("${goods}促销${info(year, 8)}")
}


