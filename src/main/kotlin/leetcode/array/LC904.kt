package leetcode.array

class LC904 {
    fun totalFruit(fruits: IntArray): Int {
        var leftP = 0
        var basketList = mutableMapOf<Int, Int>() // key存元素，value存出现的次数
        var result = 0
        var subLength: Int
        for (rightP in fruits.indices) {
            val element = fruits[rightP] //快指针扫到的元素
            if (basketList.containsKey(element)) { //包含这个元素 个数+1
                basketList[element] = basketList[element]!!.plus(1)
            } else {
                basketList[element] = 1
            }

            while (true) {
                if (basketList.size > 2) { // 元素类型>2,就开始移动左指针
                    basketList[fruits[leftP]] = basketList[fruits[leftP]]!!.minus(1) //左指针次数-1
                    if (basketList[fruits[leftP]] == 0) {
                        basketList.remove(fruits[leftP]) //删除移动的左指针
                    }
                    leftP++
                } else {
                    subLength = rightP - leftP + 1  // 子序列长度
                    if (subLength > result) {          //比较找出最长的子序列
                        result = subLength
                    }
                    break
                }
            }

        }
        return result
    }

    fun totalFruit1(fruits: IntArray): Int {
        var leftP = 0
        var basketList = mutableMapOf<Int, Int>() // key存元素，value存出现的次数
        var result = 0
        var subLength: Int
        for (rightP in fruits.indices) {
            val element = fruits[rightP] //快指针扫到的元素
            //包含这个元素 个数+1
            basketList[element] = basketList.getOrDefault(element, 0).plus(1)

            while (true) {
                if (basketList.size > 2) { // 元素类型>2,就开始移动左指针
                    basketList[fruits[leftP]] = basketList[fruits[leftP]]!!.minus(1) //左指针次数-1
                    if (basketList[fruits[leftP]] == 0) {
                        basketList.remove(fruits[leftP]) //删除移动的左指针
                    }
                    leftP++
                } else {
                    subLength = rightP - leftP + 1  // 子序列长度
                    if (subLength > result) {          //比较找出最长的子序列
                        result = subLength
                    }
                    break
                }
            }

        }
        return result
    }
}