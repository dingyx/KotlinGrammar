package com.sycamore.study.kotlin06

/**
 * @author dingyx
 * @description: 继承 04
 * 类默认都不能被继承，如果需要让某个类可继承，必须使用 open 关键字
 *
 * is 关键字 检测对象是否为某类型
 * as 转换类型 kotlin 可以进行智能类型转换 （as可以进行智能类型转换，只需要转换一次 后面可以直接使用）
 *
 * kotlin 每一个类都会继承一个超类 Any (java - - object)
 *
 * @date: 2021/6/9
 */
open class Product(val name: String) {

    fun desc() = "Product $name"

    // 函数需要 open 关键字修饰 才可以重写
    open fun load() = "Nothing .."

}

// 继承父类 重写 load 方法
class SuperProduct : Product("Super") {

    override fun load() = "SuperProduct ...."

    fun special() = "some thing special"

}

fun main() {
    val superProduct: Product = SuperProduct()
    println(superProduct.load())
    // is 检查类型
    println(superProduct is Product)
    println(superProduct is SuperProduct)
    println(superProduct is Any)

    if (superProduct is SuperProduct) {
        // as 类型转换
        println((superProduct as SuperProduct).special())
    }


}