package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 函数内联 05
 * 使用 lambda 表达式的地方，都可以使用函数引用
 * @date: 2021/6/2
 */
fun main() {
    // 传具名函数引用
    showDiscount(2021, ::getDiscountInfo)
}

fun getDiscountInfo(goods: String, discount: String): String {
    return "${goods}大促${discount}折"
}


fun showDiscount(year: Int, getDiscountInfo: (String, String) -> String) {
    val goodsName = "iPad"
    val discount = "8"
    println("${year}年${getDiscountInfo(goodsName, discount)}")
}