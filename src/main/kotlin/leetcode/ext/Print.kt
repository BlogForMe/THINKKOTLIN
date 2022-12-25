package leetcode.ext


fun IntArray.printIntArray() {
    print("[")
    this.joinToString().forEach { print(it) }
    print("]")
}

//fun IntArray.printArray() {
//    print("[")
//    this.joinToString().forEach { print(it) }
//    print("]")
//}