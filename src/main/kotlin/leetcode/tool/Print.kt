package leetcode.tool



fun IntArray.printIntArray() {
    print("[")
    this.joinToString().forEach { print(it) }
    print("]")
}