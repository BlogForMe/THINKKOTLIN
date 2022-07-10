
fun Array<IntArray>.printDimensionalArray() {
    for (i in this.indices) {
        for (j in this.indices) {
            print(" ${this[i][j]} ")
        }
        println()
    }
}