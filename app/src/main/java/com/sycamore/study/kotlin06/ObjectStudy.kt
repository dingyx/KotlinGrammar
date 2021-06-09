package com.sycamore.study.kotlin06

import java.io.File

/**
 * @author dingyx
 * @description: 对象 05
 *
 * Kotlin 使用 object 关键字，可以定义一个只产生一个实例的类-单例
 * 使用 object 有三种方式
 * 1、对象声明
 *      对象声明，有利于组织代码和管理状态，尤其是管理整个应用运行生命周期内的某些一致性状态
 * 2、对象表达式
 *      当需要某个类的变体实例，但只需要使用一次。这个对象表达式就是某个类的实例。(匿名类也遵循 object 关键字，一旦实例化，该匿名类只有一个唯一实例存在)
 * 3、伴生对象
 *      将某个对象的初始化和一个实例捆绑在一起，使用 companion 修饰符。可以在一个类定义里声明一个伴生对象，一个类里只能有一个伴生对象
 * @date: 2021/6/9
 */

// 对象声明（单例声明） object classname{} ...
object Config {
    init {
        println("load config")
    }

    fun setConfig() {
        println("set config")
    }

}


open class ViewConfig {
    open fun load() = "loading something"
}


open class ConfigMap {

    // 伴生对象
    // 只有初始化 ConfigMap 或者调用 load 函数 ，伴生对象才会创建（伴生对象只有一个实例存在）
    companion object {
        private const val PATH = "xxxxx"

        fun load() = File(PATH).readBytes()
    }
}

fun main() {
    // Config 既是类名，又是实例对象名（注意：不是静态）
    Config.setConfig()
    println(Config)
    // 同一个对象
    println(Config)

    // 对象表达式 viewConfig 是继承于 ViewConfig 的类的实例（匿名内部类，构建了一个对象）
    val viewConfig = object : ViewConfig() {
        override fun load() = "loading something new"
    }
    println(viewConfig.load())

    // 调用伴生对象里的 load 函数
    ConfigMap.load()
}


