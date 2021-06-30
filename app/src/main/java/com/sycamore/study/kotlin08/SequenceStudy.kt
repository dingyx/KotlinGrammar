package com.sycamore.study.kotlin08

/**
 * @author dingyx
 * @description: 04 Sequence
 * 惰性集合(集合元素按需产生的)
 *
 * Sequence Kotlin 内置惰性集合类型叫序列，序列不会索引排序它的内容，也不记录元素数目。在使用一个序列时，序列里的值可能无限多。
 * generateSequence 接收一个初始值作为序列的起步值，在用generateSequence定义的序列上调用一个函数时，generateSequence函数会调用你指定的迭代器函数，决定下一个要产生的值。
 *
 * @date: 2021/6/30
 */

fun main() {

    // 判断素数
    fun Int.isPrime(): Boolean {
        (2 until this).map {
            if (this % it == 0)
                return false
        }
        return true
    }

    // 获取1..100 前10个素数
    val filterList = (1..100).toList().filter { it.isPrime() }.take(50)
    println(filterList.size)

    val sequence = generateSequence(2) { value ->
        value + 1
    }.filter { it.isPrime() }.take(1000)
    println(sequence.toList())
}