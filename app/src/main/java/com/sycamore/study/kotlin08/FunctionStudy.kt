package com.sycamore.study.kotlin08

/**
 * @author dingyx
 * @description: 03、函数类别
 * 函数式应用通常由三大类函数构成：变换transform、过滤filter、合并combine
 * 每个函数都是针对集合数据类型设计，目标是产生一个最终结果。函数式编程用到的函数生来都是可以组合的，也就是说可以组合多个简单函数来构建复杂的计算行为。
 *
 * 变换：变换函数会遍历集合内容，用一个以值参形式传入变换函数，变换每一个元素，然后返回包含已修改元素的集合给链上的其他函数。
 *          常用两个变换函数是map、flatMap
 *          Map返回的集合中元素个数必须和输入集合一样，不过返回的新集合里的元素可以是不同类型的
 *          flatMap 函数操作一个集合的集合，将其中多个集合中元素合并后返回一个包含所以元素的单一集合
 *
 *  过滤：过滤函数接收一个predicate函数，用它按给定条件检查接收者集合里的元素并给出true、false判定。
 *        如果返回true，就添加到过滤函数返回的新集合里。如果返回false就不添加
 *
 *  合并：合并函数能将不同的集合合并成一个新的集合
 *          zip 合并函数能合并两个集合，返回一个包含键值对的新集合
 *          fold 合并函数接收一个初始累加器值，随后会根据匿名函数的结果更新
 *
 * @date: 2021/6/30
 */

fun main() {

    val people = listOf("dyx", "dingyx", "xy")
    // 变换函数 返回一个新集合  函数式编程范式的设计理念就是不可变数据的副本在链上的函数间传递
    val human = people.map { person ->
        "a human $person"
    }
    println(human)

    // 合并元素
    val list = listOf(listOf("a", "b", "c"), listOf("d", "e", "f")).flatMap { it }
    println(list)

    // filter 过滤
    val result = listOf("dyx", "xy", "yixiang", "dingyx").filter { it.contains("d") }
    println(result)

    val flatList = listOf(
        listOf("aa", "ab", "c"),
        listOf("d", "ae", "f")
    ).flatMap { it.filter { it.contains("a") } }
    println(flatList)

    // zip 合并函数 返回一个包含键值对的新集合
    val names = listOf("dyx", "yx", "dingyx")
    val ages = listOf(18, 24, 20)
    val persons = names.zip(ages).toMap()
    println(persons)

    // fold 函数
    // 将每个元素乘以 3 累加
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value $accumulator")
        accumulator + (number * 3)
    }
    println("Final value：$foldedValue")


}