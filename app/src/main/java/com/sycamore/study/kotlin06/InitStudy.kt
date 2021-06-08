package com.sycamore.study.kotlin06

/**
 * @author dingyx
 * @description: 初始化 03
 *
 * 初始化块：初始化代码块会在构造类实例时执行。 可以设置变量或值，以及执行有效性检查。如检查传给某构造函数的值是否有效。(与Java静态代码块不一样，静态代码块在类加载就执行)
 *
 * 执行顺序
 * 1、主构造函数里声明的属性
 * 2、类级别的属性赋值
 * 3、init 初始化块里的属性赋值和函数调用
 * 4、次构造函数里的属性赋值和函数调用
 *
 *
 * lateinit 关键字 延迟初始化
 *
 * 惰性初始化 首次使用时才初始化
 *
 *
 *
 * 注意：
 * 1、如果类级别属性定义在init代码块的后面，那么init代码块不能引用到属性
 * 2、lateinit 如果在初始化前函数调用了，那么编译正常，但运行会报错
 * 3、
 *
 * @date: 2021/6/8
 */
class InitStudy(_name: String, age: Int) {


    var name = _name
    var score = 100
    val subject: String

    // 如果延迟初始化 没有被初始化 直接调用会报错
    lateinit var hobby: String

    // 惰性初始化 首次使用时才初始化
    val skill by lazy { studySkill() }

    init {
        println("init")
        // 必须满足 require 条件 ，否则执行 lambda 表达式内容
        require(name.isNotBlank()) { "must a valid name" }
        require(age >= 18) { "must adult" }
        subject = "math"
    }

    constructor(_name: String) : this(_name, 18) {
        score = 90
    }

    fun ready() {
        hobby = "music"
    }

    fun grow() {
        // 安全检查 是否初始化
        if (::hobby.isInitialized)
            println(hobby)
    }

    fun studySkill(): String {
        println("study skill")
        return "swim"
    }


}

fun main() {
    // InitStudy("dyx", 19)
    val initStudy = InitStudy("dyx")
    // initStudy.ready()
    initStudy.grow()
    println("- - - - - -")
    println(initStudy.skill)
    println("- - - - - - -")
    println(initStudy.skill)

}