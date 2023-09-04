import kotlin.math.max

fun Array<IntArray>.printDimensionalArray() {
    for (i in this.indices) {
        for (j in this[i].indices) {
            print(" ${this[i][j]} ")
        }
        println()
    }
}

fun <T> Array<T>.printArray() {
    for (i in this) {
        print(" $i ")
    }
    println()
}

fun <T> List<T>.printArray() {
    for (i in this) {
        print(" $i ")
    }
    println()
}

fun max(a: Int, b: Int, c: Int): Int {
    var max = a
    if (b > max) {
        max = b
    }
    if (c > max) {
        max = c
    }
    return max
}


fun main() {
    val listOf = listOf("1", "2", "3", "4", "5", "6")
    println(listOf.subList(0, 5))
}

