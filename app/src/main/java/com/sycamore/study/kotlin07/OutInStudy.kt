package com.sycamore.study.kotlin07

/**
 * @author dingyx
 * @description: 03 out、in
 *
 * out 协变
 * 如果泛型只将泛型类作为函数的返回(输出)，那么使用 out 。可以称为生产类/接口，因为它主要是用来生产(produce)指定的泛型对象
 *
 * in 逆变
 * 如果泛型类只将泛型类型作为参数的入参(输入)，那么使用in 。可以称为消费者类/接口，因为它主要是用来消费指定的泛型对象
 *
 * invariant 不变
 * 如果泛型类既将泛型类型作为函数参数，又将泛型类型作为函数的输出，那么既不用out也不用in
 *
 * 为什么使用 out、in
 * 子类泛型对象可以赋值给父类泛型对象，用out
 * 父类泛型对象可以赋值给子类泛型对象，用in
 *
 * @date: 2021/6/21
 */

// out
interface Production<out T> {
    fun product(): T
}

// in
interface Consumer<in T> {
    fun consume(item: T)
}

interface ProductionConsumer<T> {
    fun product(): T
    fun consume(item: T)
}

open class Food

open class FastFood : Food()

class Burger : FastFood()

// Food 生产者
class FoodStore : Production<Food> {
    override fun product(): Food {
        println("produce food")
        return Food()
    }
}

// FastFood 生产者
class FastFoodStore : Production<FastFood> {
    override fun product(): FastFood {
        println("produce fast food")
        return FastFood()
    }
}

// Burger 生产者
class BurgerStore : Production<Burger> {
    override fun product(): Burger {
        println("produce burger")
        return Burger()
    }
}

// EveryBody 消费者
class EveryBody : Consumer<Food> {
    override fun consume(item: Food) {
        println("consume food")
    }
}

// ModernPeople 消费者
class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("consume fast food")
    }
}

// American 消费者
class American : Consumer<Burger> {
    override fun consume(item: Burger) {
        println("consume burger")
    }
}


fun main() {

    val production1: Production<Food> = FoodStore()

    // 不同于 java
    // 在kotlin中，因为 Production 泛型定义有 out 关键字，可以赋值为子类类型
    // 子类泛型对象可以赋值给父类泛型对象
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<Food> = BurgerStore()


    // Consumer 的 Burger 是子类类型 EveryBody 里面是父类类型Food
    // 使用 in 关键字 父类类型对象可以赋值给子类类型
    val consumer1: Consumer<Burger> = EveryBody()
    val consumer2: Consumer<Burger> = ModernPeople()
    consumer2.consume(Burger())     // print consume fast food 实际类型还是 ModernPeople
    val consumer3: Consumer<Burger> = American()


}