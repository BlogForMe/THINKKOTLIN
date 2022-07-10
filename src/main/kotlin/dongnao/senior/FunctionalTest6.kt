package senior

//判断是否是素数
fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) {
            return false
        }
    }
    return true
}

fun main() {
    //产生头1000个元素
    //假定 0 - 5000之内，可以找到1000个元素
    val toList = (1..5009).toList().filter { it.isPrime() }.take(1000)
    println(toList.size)

    val oneThousandPrimes = generateSequence(2) { value ->
        value + 1
    }.filter { it.isPrime() }.take(1000)
    println(oneThousandPrimes.toList().size)
}