@file:JvmName("NewStudy")

package com.sycamore.study.kotlin09

import java.io.IOException
import kotlin.jvm.Throws

/**
 * @author dingyx
 * @description: 01 kotlin、Java
 *  互操作性和可空性
 *
 * String! 平台类型
 *
 * 类型映射：代码运行时，所有的映射类型都会重新映射回对应的Java类型
 *
 * 属性访问：不需要调用get、set方法，可以使用赋值语法设置Java字段值  tv_name.text = "yx"
 *
 * @JvmName @file:JvmName("NewStudy")注解指定编译类的名字  KotlinJavStudy.go() -> NewStudy.go()
 *
 * @JvmField 使Java调用时不需要写 get、set    new KotlinJavaStudy() .getSpells() ->  new KotlinJavaStudy().spells
 *
 * @JvmOverloads 为了使Java可以调用，使用 JvmOverloads 强迫重载
 *
 * @JvmStatic 允许Java直接调用伴生对象里面的函数
 *
 * @JvmThrows 为了让Java调用时catch指定异常 使用 @Throws(IOException::class)
 *
 * 函数类型操作
 *  Function1<String,Unit> translator =  KotlinJavaStudy.getTranslator(); translator.invoke("dyx");
 *
 * @date: 2021/6/30
 */

class KotlinJavaStudy {

    @JvmField
    val spells = listOf("go", "go go", "going")

    fun go() {

    }

    @JvmOverloads
    fun handFood(left: String = "egg", right: String = "beef") {
        println("$left  $right")
    }

    companion object {
        @JvmField
        val MAX_COUNT = 10

        @JvmStatic
        fun printCount() = println("$MAX_COUNT")
    }

    @Throws(IOException::class)
    fun test() {
        throw IOException()
    }

    val translator = { str: String ->
        println(str.toLowerCase().capitalize())
    }

}

fun main() {

}