package com.sycamore.study.kotlin05

/**
 * @author dingyx
 * @description: Map 集合
 *
 * Map 创建 mapOf
 * Pair 创建键值对
 * 使用 to 组成键值对（to 不是关键字，是省略 . 、参数 的特殊函数）
 *
 * 读取 Map 的值
 * [] 取值运算符(key不存在返回null值)、getValue（key不存在抛出异常）、getOrElse、getOrDefault
 *
 * 遍历 Map  forEach
 *
 *  可变 MutableMap
 *  添加元素 += 、put 、 mutableMap["x"] = ..
 *  getOrPut
 * @date: 2021/6/4
 */
fun main() {

    val map = mapOf("dyx" to 20, "dingyx" to 18, "yx" to 24)
    println(map)

    val myMap = mapOf(Pair("dyx", 20), Pair("dingyx", 18), Pair("yx", 24))
    println(myMap)

    println(map["ee"])      // null
    // println(map.getValue("ee"))     // error
    println(map.getOrElse("ee") { 0 })  // 0
    println(map.getOrDefault("ee", 0))

    // 遍历 map
    map.forEach {
        println("key:${it.key}  value:${it.value}")
    }

    map.forEach { (key: String, value: Int) ->
        println("key:${key}  value:${value}")
    }

    // 可变 map
    val mutableMap = mutableMapOf("dyx" to 20, "dingyx" to 18, "yx" to 24)
    // 添加元素
    mutableMap += "xxyy" to 25
    mutableMap.put("yyy", 26)   //  mutableMap["yyy"] = 26
    println(mutableMap)
    // 获取元素、 没有就赋值
    mutableMap.getOrPut("lh") { 18 }
    println(mutableMap)


}