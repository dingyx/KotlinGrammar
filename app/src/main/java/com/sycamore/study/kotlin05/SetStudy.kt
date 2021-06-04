package com.sycamore.study.kotlin05

/**
 * @author dingyx
 * @description: Set 集合 02 （没有重复元素）
 * @date: 2021/6/4
 *
 * 获取元素 elementAt 函数
 * setOf 不可变 、 mutableSetOf 可变
 *
 * list set 集合转换 toSet、toList
 * 转换distinct
 *
 */
fun main() {

    val set = setOf("dyx", "lh", "dyx")
    println(set.elementAt(1))

    val mutableSet = mutableSetOf("dyx", "lh")
    mutableSet += "xy"
    println(mutableSet)


    // 集合转换
    val mySet = listOf("dyx", "lh", "xy", "dyx").toSet()
    println(mySet)
    // 去重 toSet().toList() 可以使用 distinct
    val distinct = listOf("dyx", "lh", "xy", "dyx").distinct()
    println(distinct)
}