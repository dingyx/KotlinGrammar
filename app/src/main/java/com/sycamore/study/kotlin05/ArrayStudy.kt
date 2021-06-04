package com.sycamore.study.kotlin05

import java.io.File

/**
 * @author dingyx
 * @description: 数组类型
 * Kotlin 提供各种 Array (引用类型可以编译成Java基本数据类型)
 * IntArray、DoubleArray、LongArray、ShortArray、ByteArray、FloatArray、BooleanArray  - - - 创建 intArrayOf
 * Array - - - 创建 arrayOf 对象数组
 * @date: 2021/6/4
 */
fun main() {

    intArrayOf(10, 20, 30)
    // list 转 array
    listOf(10, 20, 30).toIntArray()

    val fileArray = arrayOf(File("x"), File("y"), File("z"))

}