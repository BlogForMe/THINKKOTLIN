fun Array<IntArray>.printDimensionalArray() {
    for (i in this.indices) {
        for (j in this.indices) {
            print(" ${this[i][j]} ")
        }
        println()
    }
}

fun main() {
    val listOf = listOf("1", "2", "3", "4", "5", "6")
    println(listOf.subList(0, 5))

}

