package com.sycamore.study.kotlin04

import kotlin.math.roundToInt

/**
 * @author dingyx
 * @description: 字符串、数字 01
 *
 * substring 截取字符串。支持 IntRange类型(一个整数范围的类型)参数，until表示创建的范围不包括上限值
 *
 * split 分割字符串，返回List集合。List集合又支持解构语法特性(允许在一个表达式里给多个变量赋值，解构常用来简化变量的赋值)。
 *
 * replace 字符串替换
 *
 * == === 字符串比较
 * == 检查字符串是否匹配 ===检查两个变量是否指向堆内存同一对象
 *
 * forEach 字符串遍历
 *
 *
 * 数字类型 Byte、Short、Int、Long、Float、Double
 * 安全转换函数 toDoubleOrNull、toIntOrNull (不能正确转换返回 null)
 *
 * Double 转 Int toInt(去掉小数位)、roundToInt（四舍五入）
 *
 *
 * @date: 2021/6/3
 */

const val NAME = "Ding Yi Xiang"

fun main() {

    val index = NAME.indexOf("X")
    println(NAME.substring(0, index))
    // IntRange
    println(NAME.substring(0 until index))


    val data = NAME.split(" ")
    // 取值 data[0]
    println(data[0])
    // 解构语法 一次性给多个变量赋值
    val (first, second, third) = NAME.split(" ")
    println("$first     $second      $third")


    // replace 正则替换
    val str = "Jack love Rose"
    val newStr = str.replace(Regex("[love ]")) {
        when (it.value) {
            "l" -> "ll"
            "o" -> "oo"
            "v" -> "vv"
            "e" -> "ee"
            " " -> "&"
            else -> it.value
        }
    }
    println(str)
    println(newStr)


    // 字符串比较
    val str1 = "Dyx"
    val str2 = "Dyx"
    println(str1 == str2)   // true 内容一样
    println(str1 === str2)  // true 字符串在常量池 (kotlin、java 字符串是不可变的)

    val str3 = "dyx".capitalize();
    println(str1 == str3)   // true 内容一样
    println(str1 === str3)  // false capitalize 得到新的字符串 str1、str3 不是指向同一个内存地址

    "dingyixiang".forEach {
        print("$it ")
    }


    // 数字转换函数
    println("12.3".toDoubleOrNull())    // 12.3
    println("12.3".toIntOrNull())       // null

    println(8.95.toInt())
    println(8.95.roundToInt())
    println("%.2f".format(8.9556))  // 四舍五入

}