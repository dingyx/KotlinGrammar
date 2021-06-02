package com.sycamore.study.kotlin02


/**
 * @author dingyx
 * @description: 函数类型作为返回类型、闭包 06
 * 匿名函数 引用定义自己的函数里面定义的变量 ｛引用hour｝
 *
 * 在 Kotlin 中，匿名函数能修改和引用定义在自己作用于之外的变量(匿名函数引用定义自身函数里的变量)，在 Kotlin 中就是闭包
 * 能够接收函数、返回函数的函数又叫高级函数，高级函数广泛应用于函数式编程中。
 * @date: 2021/6/2
 */
fun main() {

    // generateGoodsInfo 是一个匿名函数
    val generateGoodsInfo = generateInfo(2021)

    println(generateGoodsInfo("iMac"))
}

/**
 * generateDiscountInfo 返回的是一个函数
 */
fun generateInfo(year: Int): (String) -> String {
    val hour = (0..23).shuffled().first()
    // 匿名函数 引用了 generateInfo 里面定义的变量 hour
    return {
        val disInfo = " [${it}] "
        "${year}年${disInfo}开始打折大促啦！！！ 最后倒计时${hour}小时"
    }
}