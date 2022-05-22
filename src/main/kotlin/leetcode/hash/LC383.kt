package leetcode.hash

class LC383 {
    //若 a = i++; 则等价于 a=i;i=i+1;
    //而 a = ++i; 则等价于 i=i+1;a=i;
    //a += 1 和   a = a + 1
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val record = IntArray(26)
        magazine.toCharArray().forEach { char ->
            record[char - 'a'] += 1 // 这里可以优化
        }
        ransomNote.toCharArray().forEach { char ->
            record[char - 'a'] -= 1
        }

        record.forEach {
            if (it < 0) {           //就这里和242.有效的字母异位词 不一样，数量不够就<0
                return false
            }
        }
        return true
    }

    fun canConstruct02(ransomNote: String, magazine: String): Boolean {
        val record = IntArray(26)
        magazine.toCharArray().forEach { char ->
            record[char - 'a']++
        }
        ransomNote.toCharArray().forEach { char ->
            record[char - 'a']--
        }
        record.forEach {
            if (it < 0) {           //就这里和242.有效的字母异位词 不一样，数量不够就<0
                return false
            }
        }
        return true
    }
}

fun main() {
    val record = IntArray(26)
    record['c' - 'a']++
    record['c' - 'a']++
    println(record['c' - 'a'])
}