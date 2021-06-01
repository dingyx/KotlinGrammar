package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 匿名函数简化 04
 *
 * 如果一个函数的lambda参数排在最后，或者是唯一参数，那么括住lambda值参的圆括号可以省略
 * @date: 2021/6/1
 */

fun main() {

    val count = "test".count()
    val tCount = "test".count({ letter ->
        letter == 't'
    })
    // 简化
    val simplifyTCount = "test".count { letter ->
        letter == 't'
    }


/*    val discountInfo = { year: Int, discount: Int ->
        "${year}年${discount}折"
    }
    showInfo("iPad", discountInfo)*/
    // 简化写法 lambda表达式排在最后可以省略lambda表达式括号
    showInfo("iPad") { year: Int, discount: Int ->
        "${year}年${discount}折"
    }
}


fun showInfo(goods: String, info: (Int, Int) -> String) {
    val year: Int = (2010..2021).shuffled().last()
    println("${goods}促销${info(year, 8)}")
}