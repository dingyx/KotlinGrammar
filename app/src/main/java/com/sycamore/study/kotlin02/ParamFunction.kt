package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 定义参数是函数的函数 03
 *
 * 函数内联
 * lambda可以更灵活的编写应用
 * lambda 在 JVM 以实例对象存在，JVM 会为所以同 lambda 打交道变量分配内存。这样就带来了严重内存消耗。
 * kotlin 提供了一种内联的优化机制，JVM 不需要 lambda 实例，避免了变量内存分配。哪里需要 lambda ，编译器就会将函数体复制粘贴到哪里。
 *
 * 使用 lambda 的递归函数无法内联，因为会导致复制粘贴无限循环，编译发出警告。
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


