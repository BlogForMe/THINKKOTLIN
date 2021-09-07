package main.java.senior

fun main() {
    val list1 = listOf("jon", "john1", "john2")
    val list2 = listOf("l1", "l2", "l3")

    val toMap = list1.zip(list2).toMap()
    println(toMap)

    //将每个元素值 乘以3后累加起来
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accmulator value: $accumulator")
        accumulator + (number * 3)
    }
    println("Find value: $foldedValue")

}