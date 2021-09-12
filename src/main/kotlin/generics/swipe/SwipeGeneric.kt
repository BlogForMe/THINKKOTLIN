package generics.swipe

import generics.`interface`.PerImtImpl01

fun main() {
    val p1 = PerImtImpl01<String>()
    val p2 = PerImtImpl01<Int>()
    println(p1.javaClass == p2.javaClass)
    println(p1.javaClass === p2.javaClass)

}