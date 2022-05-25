package leetcode.hash

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class LC49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ansMap = HashMap<String, ArrayList<String>>() // 相同异位词的key, 和所有异位词的数组
        strs.forEach { str ->
            val char = str.toCharArray() // String to char 进行排序，结果相同异位词key一致
            Arrays.sort(char)
            val key = String(char)
            if (!ansMap.containsKey(key)) { // map不存在，就创建新的ArrayList()
                ansMap[key] = ArrayList()
            }
            ansMap[key]?.add(str)          //拿到ArrayList(),添加元素

        }
        return ArrayList(ansMap.values)
    }
}