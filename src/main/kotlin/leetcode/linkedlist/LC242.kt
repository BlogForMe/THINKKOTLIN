package leetcode.linkedlist

class LC242 {
    fun isAnagram(s: String, t: String): Boolean {
        val record = IntArray(26) // 存整数，就用整形数
        s.toCharArray().forEachIndexed { _, char ->
            record[char - 'a'] += 1
        }

        t.toCharArray().forEachIndexed { _, char ->
            record[char - 'a'] -= 1
        }

        record.forEach {
            if (it != 0) {
                return false
            }
        }
        return true
    }
}


fun main() {
//    println(('c' - 'a'))
//    val record = CharArray(26)
//    println(record[0])

//    val intArrayOf = intArrayOf(26)
//    println(intArrayOf[1])

    val intArray = IntArray(26)
    println(intArray[2])


}