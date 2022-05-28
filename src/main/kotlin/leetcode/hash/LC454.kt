package leetcode.hash

class LC454 {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        nums1.forEach { n1 ->
            nums2.forEach { n2 ->
                map[n1 + n2] = map.getOrDefault(n1 + n2, 0) + 1
            }
        }

        var ans = 0
        nums3.forEach { n3 ->
            nums4.forEach { n4 ->
                if (map.containsKey(-n3 - n4)) { // 6, 12 , -7 , -11   4个数2 2相加 不管怎么组合，结果都一样
                    ans += map[-n3 - n4] ?: 0  // 根据当前的key,区前面num1 num2找个数
                }
            }
        }
        return ans
    }
}