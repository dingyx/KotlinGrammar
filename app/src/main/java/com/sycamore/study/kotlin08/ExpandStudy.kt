package com.sycamore.study.kotlin08

// import com.sycamore.study.extension.randomTake
// 重命名扩展  扩展函数类名可以支持修改 randomTake -> randomGet
import com.sycamore.study.extension.randomTake as randomGet

/**
 * @author dingyx
 * @description: 01 定义扩展函数、扩展属性、扩展文件
 * 不直接修改类定义情况下，增加类功能
 * 在无法接触某个类，或者类没有被open修饰无法继承时可以使用，增加类功能
 *
 * 定义扩展函数和定义一般函数差不多。但有一点区别，除了函数定义，你还需要指定接受功能扩展的接收者类型
 *
 * 泛型扩展函数
 * 新的泛型扩展函数不仅可以支持任何类型接收者，还保留了接收者类型信息。使用泛型扩展函数后，扩展函数能够支持更多类型的接收者，适用范围更广。
 *
 * 泛型扩展函数在 Kotlin 标准库里随处可见(let、apply..)，let 函数被定义成泛型扩展函数。所以能支持任何类型，它接收一个lambda表达式，这个lambda表达式接收者T作为参值，返回的R-lambda表达式返回的任何新类型
 *
 * 扩展属性 (eg.String.numVowels get()=count{"aeiou".countains(it)}  )
 *
 * 可空类扩展，在扩展函数体解决可能出现的空值问题
 *
 * infix 关键字
 * 适用于单个参数的扩展函数，可以使语法更简洁。如果一个函数定义使用了 infix 关键字，那么调用时，接收者和函数之间的点和参数的括号都可以省略
 *
 * 定义扩展文件
 * 扩展函数需要在多个文件里使用，可以将它定义在单独文件，然后 import
 *
 * Kotlin 标准库提供的很多功能都是扩展函数和扩展属性实现的，包含类扩展的标准库文件通常都是以类名加s后缀来命名的。eg。Sequences.kt、Ranges.kt、Maps.kt
 *
 * @date: 2021/6/28
 */
// String 增加扩展函数
// fun String.addExt(amount: Int = 1) = this + " !".repeat(amount)

// fun Any.easyPrint() = println(this)

fun String.addExt(amount: Int = 1) = this + " !".repeat(amount)

/*
fun String.easyPrint(): String {
    println(this)
    return this
}*/
fun <T> T.easyPrint(): T {
    println(this)
    return this
}

// let 函数
// 传入 lambda 表达式 (参数类型 T，返回值 R)
// 调用者T 作为参数传入lambda表达式，返回新类型 R
// let 函数返回的是lambda表达式执行结果 R
public inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

// String 定义扩展属性，统计元音字母个数
val String.numVowels
    get() = count { "aeiou".contains(it) }

// 可控类扩展
infix fun String?.printWithDefault(default: String) = println(this ?: default)


fun main() {
    "abc".easyPrint().addExt(3).easyPrint()
    15.let { }

    // 调用 上面定义的let函数
    val letResult = "abd".let {
        it + "123"
        it.length
    }
    println(letResult)

    "abcdefgh".numVowels.easyPrint()

    val string: String? = null
    string.printWithDefault("default")
    // 当函数定义前 使用 infix 可以使用省略写法
    string printWithDefault "abc"
    mapOf("dyx" to 18)  // "dyx".to(18)

    // listOf("12", 12, "java", "python").randomTake().easyPrint()
    setOf("12", 12, "java", "python").randomGet().easyPrint()

}