package test

val name = "jon"
const val age = "joo"

object ConstantObject {
    val name = "jon"
    const val age = "joo"
}
class ConstantClass {
    companion object {
        val name = "jon"
        const val age = "joo"
    }
}


fun main() {
//    val d:String? ="null"
//    val df=d?.length?:0
//    println(df)

//    val arrayOf1 = arrayListOf("a", "b", "c")
//    val arrayOf2 = arrayListOf("c", "d", "e")
//    println(arrayOf1.subtract(arrayOf2))
//    println(arrayOf2.subtract(arrayOf1))

    var ss:String?=null
    val b = ss is String
    print(b)

    "".uppercase()

}
