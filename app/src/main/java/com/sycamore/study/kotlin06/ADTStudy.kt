package com.sycamore.study.kotlin06

/**
 * @author dingyx
 * @description: 枚举类
 * 枚举类:通常用来定义常量集合的一种特殊类
 * 枚举类也可以定义属性、函数
 *
 * 代数数据类型
 * 可以用来表示一组子类的闭集，枚举就是一种简单的ADT
 *
 * 对于更复杂的 ADT ，可以使用 Kotlin 的密封类(sealed class) 来实现更复杂的定义。
 * 密封类可以用来定义一个类似于枚举的ADT，但你可以更灵活地控制某个子类型。
 * 密封类可以有若干个子类，要继承密封类，这些子类必须和它定义在同一个文件里。
 *
 *
 * @date: 2021/6/19
 */

// 枚举类（简单的ADT）
enum class Direction {
    EAST, WEST, SOUTH, NORTH
}

// 代数数据类 ADT
enum class Position(private val coordinate: Coordinate) {

    EAST(Coordinate(1, 0)),
    WEST(Coordinate(-1, 0)),
    SOUTH(Coordinate(-1, 0)),
    NORTH(Coordinate(1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)

}

// 密封类
sealed class LicenseStatus {

    // object - - 代表单例 没有状态、属性 如果用class每次产生一个对象，所以用object更好
    object Unqualified : LicenseStatus()

    object Learning : LicenseStatus()

    class Qualified(val licenseId: String) : LicenseStatus()

}


class Driver(var status: LicenseStatus) {
    fun checkLicense(): String {
        return when (status) {
            is LicenseStatus.Unqualified -> "go to study"
            is LicenseStatus.Learning -> "learning"
            is LicenseStatus.Qualified -> "Qualified id ${(this.status as LicenseStatus.Qualified).licenseId}"
        }
    }
}

fun main() {
    println(Direction.EAST)
    println(Direction.EAST is Direction)

    println(Position.EAST.updateCoordinate(Coordinate(10, 20)))

    val status = LicenseStatus.Qualified("123455")
    val driver = Driver(status)
    println(driver.checkLicense())
}