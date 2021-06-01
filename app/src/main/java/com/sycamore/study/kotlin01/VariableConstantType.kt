package com.sycamore.study.kotlin01

/**
 * @author dingyx
 * @description: 变量、常量、类型
 *
 * double shift show kotlin bytecode
 *
 * 内置数据类型 String、Char、Boolean、Int、Double、List、Set、Map
 *
 * 编译时常量只能在函数之外定义
 *
 * kotlin 只提供引用类型一种数据类型，kotlin 编译器会在Java字节码中自动将一些类型转换为基本数据类型
 *
 * @date: 2021/5/31
 */
const val str = "hello"

fun main() {

    // 声明变量可修改 关键字 var
    //var str01: String = "hello kotlin" 声明赋值- -类型推断- -可以省略类型定义
    var str01 = "hello kotlin"
    println(str01)

    // 只读变量 val
    val str02 = "hello world"
    println(str02)

    println(str)

}