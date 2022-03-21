import java.util.*

fun main() {
//    val pathComponents:Array<String>? = arrayOf("")
//    val pathComponents:Array<String>? = null
////    var ss = pathComponents?.size ?: 0  < 1
//    var ss = pathComponents?.size ?: 0
//    println(ss)

//    val arrayListOf = arrayListOf(1, 2, 3, 4, 5, 6)
//    val toMutableList = arrayListOf.toMutableList()
//    toMutableList.remove(1)
//    println("arrayListOf  $arrayListOf")
//    println("toMutableList $toMutableList")
//    Collections.swap(toMutableList,0,1)
//    println(toMutableList)

    // 1,3
    // 1 3 4 2,5,6


//    val removeData = toMutableList.removeAt(1) // 1 3 4 5 6
//
//    toMutableList.add(3, removeData) // 1 3 4 2 5 6
//
//    println(toMutableList)

//    val arrayListOf1 = arrayListOf(1, 2, 3, 4, 5)
//    val arrayListOf2 = arrayListOf(1, 3, 2, 4, 5)
//    val arrayListOf6 = arrayListOf(1, 3, 2, 4, 5)
//    println(arrayListOf6 == arrayListOf2)
//
//    val arrayListOf3 = arrayListOf(1, 2, 3, 4)
//    println(arrayListOf3 == arrayListOf1)
//    println(arrayListOf1==arrayListOf6)

//    val filterNot = arrayListOf1.toMutableList().filterNot { it > 3 }
//    println(filterNot)

    val input= "One, Two, Three, Four, Five"
    val result = input.split(",").map { it.trim() }
    println(result)
}

private fun islegal(): Boolean {
    val pathComponents: List<String>? = null
    val afn = (pathComponents?.size ?: 0 < 1)
    println("pathComponents " + afn)

    return when {
        afn -> false
        else -> true;
    }
}

fun func1(): Boolean {
    println("func1")
    return true
}

fun func2(): Boolean {
    println("func2")
    return true
}

infix fun <T> Collection<T>.deepEqualTo(other: Collection<T>): Boolean {
    // check collections aren't same
    if (this !== other) {
        // fast check of sizes
        if (this.size != other.size) return false
        val areNotEqual = this.asSequence()
            .zip(other.asSequence())
            // check this and other contains same elements at position
            .map { (fromThis, fromOther) -> fromThis == fromOther }
            // searching for first negative answer
            .contains(false)
        if (areNotEqual) return false
    }
    // collections are same or they are contains same elements with same order
    return true
}

//        println("islegal()" + islegal())
