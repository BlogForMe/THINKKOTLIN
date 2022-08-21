package leetcode.ext



fun IntArray.printIntArray() {
    print("[")
    this.joinToString().forEach { print(it) }
    print("]")
}