package com.sycamore.study.kotlin05

/**
 * @author dingyx
 * @description: List 集合 01
 *
 * 创建元素 listOf
 * 获取元素 list[3]、getOrElse getOrNull
 *
 * 可变列表
 * Kotlin中，支持内容修改的列表叫可变列表。用 mutableListOf 来创建可变列表
 * List支持 toList、toMutableList 实现转换
 *
 * mutator 函数
 * 能修改课表列表的函数有一个统一的名字：mutator 函数 （add、remove、...）
 * 运算符重载：添加元素运算符与删除元素运算符
 * 基于lambda表达式指定条件删除元素
 *
 * for 循环、forEach 函数
 *
 * 解构
 *
 * @date: 2021/6/4
 */
fun main() {

    val list = listOf("d", "y", "x")
    println(list[1])
    // getOrElse 获取指定位置元素  提供默认值的 lambda 表达式
    println(list.getOrElse(4) { "dyx" })
    // 出现异常返回结果 null
    println(list.getOrNull(4))
    println(list.getOrNull(4) ?: "dyx")


    val mutableList = mutableListOf("d", "y", "x")
    mutableList.add("!")
    println(mutableList)
    mutableList.remove("d")

    // 添加元素 (运算符重载)
    mutableList += "!!"
    mutableList -= "x"
    println(mutableList)

    // 元素里面包含 ！则移除这个元素
    mutableList.removeIf {
        it.contains("!")
    }
    println(mutableList)


    // 遍历元素
    for (s in list) {
        println(s)
    }
    list.forEach {
        println(it)
    }
    list.forEachIndexed { index, s ->
        println("index:$index  $s")
    }

    // 解构 (使用下划线可以过滤元素赋值)
    val (first, _, third) = list
    println("$first   $third")

}