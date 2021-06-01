package com.sycamore.study.kotlin02

/**
 * @author dingyx
 * @description: 匿名函数 02
 * 通常整体传递给其他函数
 * 可以根据需要制定规则，轻松定制标准库里的内置函数
 *
 * 匿名函数也有类型，可以当做变量赋值给函数的变量，这样匿名函数就可以在代码中传递。变量有类型，函数也会有类型。函数的类型由传入的参数和返回值类型决定。
 *
 * 和具名函数不一样，除了极少数情况匿名函数不需要return关键字返回数据，匿名函数会隐式自动返回函数体最后一行的语句
 * 和具名函数一样，匿名函数可以不带参数，也可以带一个或多个任何类型参数。需要带参数时，参数的类型放在匿名函数的类型定义中，参数名则放在函数中。
 *
 * it 关键字   Kotlin中匿名函数只有一个参数时，可以使用it关键字表示参数名，如果需要传入多个参数时，it关键字就不能使用
 *
 * 定义一个变量时，如果已经把一个匿名函数作为变量赋值给它，就不需要显示指明变量类型(也就是匿名函数返回值类型)  quest
 * 带参数的函数也支持类型推断，但为了帮助编译器更准确的推断变量类型，匿名函数的参数名和参数类型必须有
 *
 * 匿名函数称为 lambda ，将它定义为 lambda 表达式，返回的结果为 lambda 结果。
 * @date: 2021/6/1
 */
fun main() {
    val total = "Hello Kotlin".count()
    println(total)

    val totalL = "Hello Kotlin".count({ countl ->
        countl == 'l'
    })
    println(totalL)


    // 变量的类型是一个匿名函数
/*    val guess: () -> String
    guess = {
        val str = "Hello Kotlin"
        "String is $str"
    }*/
    val guess: () -> String = {
        val str = "Hello Kotlin"
        "String is $str"
    }
    println(guess())

    // 匿名函数 参数、返回值 String 类型
    val question: (String) -> String = { str ->
        "param is $str"
    }
    println(question("Kotlin"))


    // 匿名函数只有一个参数时可以省略
    val printParam: (String) -> String = {
        "only a param is $it"
    }
    println(printParam("test"))


    // 匿名函数 返回值可以类型推断
    val quest = {
        val str = "string"
        "a quest $str"
    }
    println(quest())

    // 带参数的函数也支持类型推断
    val printParamName = { name: String, age: Int ->
        val str = "hello"
        "$str $name is $age years old"
    }
    println(printParamName("dyx", 20))

}