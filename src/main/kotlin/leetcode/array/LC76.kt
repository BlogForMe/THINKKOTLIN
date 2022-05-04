package leetcode.array

/**
 * 核心思想: s的 left right,已经覆盖了t字串，那么就移动left,看看是否还在范围内
 * 通过判断T中A B C都 >0没被抵消， <0说明 s有多余这个字符个数
 */
class LC76 {
    fun minWindow(s: String, t: String): String {
        val map = mutableMapOf<Char, Int>()
        for (element in t) {
            map[element] = map.getOrDefault(element, 0).plus(1)
        }

        var leftP = 0 // 左指针
        var rightLast = 0 //最后匹配的最短的右指针
        var resultLength = Int.MAX_VALUE
        var resultStr = "" // 最短结果字符
        for (rightP in s.indices) {
            if (map.containsKey(s[rightP])) {  // t字符包含该元素， 元素+1
                map[s[rightP]] = map.getOrDefault(s[rightP], 0).minus(1)
            }
            while (isMatch(map, t)) { // 判断这个S的left right中是否含有t所有字符
                val subLength = rightP - leftP + 1
                if (subLength < resultLength) {
                    rightLast = rightP
                    resultLength = subLength
                    resultStr = s.substring(
                        leftP,
                        rightLast + 1
                    )
                }
                if (map.containsKey(s[leftP])) { // 向右移动left,如果元素是 map t中的，就+1，因为这个不算了
                    map[s[leftP]] = map.getOrDefault(s[leftP], 0).plus(1)
                }
                leftP++
            }
        }

        return resultStr//  the beginning index, inclusive ,endIndex – the ending index, exclusive. [begin,end)
    }


    /**
     * map中有元素>0,说明有元素还没有,map<0才全部抵消了
     */
    private fun isMatch(map: Map<Char, Int>, t: String): Boolean {
        for (element in t) {
            if (map[element]!! > 0) {
                return false
            }
        }
        return true
    }

}