package com.sycamore.study.kotlin06


/**
 * @author dingyx
 * @description:构造函数 02
 *
 * 主构造函数 使用临时变量为各个属性提供初始值，在 Kotlin 中，为便于识别。临时变量(包括仅引用一次的参数，通常都会以下划线开头的名字命名)
 * 构造函数可以直接定义属性
 *
 * 次构造函数 定义多个次构造函数配置不同参数组合
 *
 * 默认参数 定义构造函数时，可以给构造函数的参数指定默认值，如果用户调用时不提供值参，就是用默认值
 *
 * @date: 2021/6/8
 */
// 主构造函数 参数_name、_age、_isNormal 构造函数里定义了属性
class ConstructorStudy(_name: String, _age: Int, var isNormal: Boolean) {


    // 次构造函 定义不同参数组合
    constructor(_name: String) : this(_name, 18, true)

    constructor(_name: String, _age: Int) : this(_name, _age, true) {
        // 次构造函数 初始化代码逻辑
        this.name = name.toUpperCase()
    }

    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    var age = _age
    // var isNormal = _isNormal

}

// 构造函数 参数指定默认值
class Constructor(_name: String, var age: Int = 20, private val isNormal: Boolean) {

    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

}

fun main() {
    val constructorStudy = ConstructorStudy("dyx", 24, true)
    constructorStudy.age = 25
    // constructorStudy.name = ""  private error 不可重新赋值
    constructorStudy.isNormal = false

    val constructorStudy1 = ConstructorStudy("lh")
    println(constructorStudy1.age)

    val constructorStudy2 = ConstructorStudy("lh", 18)
    println(constructorStudy2.name)

    val constructor = Constructor(_name = "dyx", isNormal = true)
    println(constructor.age)

}