package leetcode.backtrack.combination

class LC131 {
    val result = ArrayList<List<String>>()
    private val path = ArrayList<String>()
    fun partition(s: String): List<List<String>> {
        backTrack(s, 0)
        return result
    }

    private fun backTrack(s: String, startIndex: Int) {
        if (startIndex >= s.length) { // 纵向到叶子节点，就网上回溯
            result.add(path.toList())
            return //可以用
        }
        for (i in startIndex until s.length) {  //for循环是 横向切割
            if (isPalindromeNum(s,startIndex,i+1)){ // 判断startIndex,到 i+1是否是回文串,
                val str = s.substring(startIndex,i+1)
                path.add(str)

//                backTrack(s, i + 1)    //递归是 纵向切割， 这个放if里面可能更好.
//                path.removeAt(path.size-1)
            }else{
                continue // 如ab不是回文串，也不用继续了
            }
            backTrack(s, i + 1)    //递归是 纵向切割， 这个放if里面可能更好.
            path.removeAt(path.size-1)
        }
    }

    fun isPalindromeNum(str: String,start:Int,end:Int): Boolean {
        if (str.isEmpty()) {
            return false
        }
        val charArray = str.substring(start,end)
        for (i in 0 until charArray.length / 2) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false
            }
        }
        return true
    }

}