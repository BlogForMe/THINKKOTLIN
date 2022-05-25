package leetcode.hash

class LC438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val sLength = s.length
        val pLength = p.length
        if (sLength < pLength) { // 如果字符s的长度 小于p 直接返回
            return emptyList()
        }

        val ansList = arrayListOf<Int>()
        val sCount = IntArray(26)
        val pCount = IntArray(26)

        val sCharArray = s.toCharArray()
        val pCharArray = p.toCharArray()
        for (i in 0 until pLength) {      //初始情况， p s字符相同，看是否相等.
            sCount[sCharArray[i] - 'a']++          // 对于位置字符个数
            pCount[pCharArray[i] - 'a']++
        }
        if (sCount.contentEquals(pCount)) {         //比较初始数量
            ansList.add(0)
        }

        for (i in 0 until (sLength - pLength)) { // 从0开始，s的字符 左边-1 右边+1 字符，调整相应位置字符数量，
            sCount[sCharArray[i] - 'a']--
            sCount[sCharArray[i + pLength] - 'a']++
            if (sCount.contentEquals(pCount)) {
                ansList.add(i + 1)              //如果 i==0, 那么0位置字符去掉， p.length + 0 字符+1, 新的字符开始位置就是1了
            }
        }
        return ansList
    }


}