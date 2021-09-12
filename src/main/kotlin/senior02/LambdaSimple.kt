package elementary
//https://www.bilibili.com/video/BV1xv411k7Dd?p=3&spm_id_from=pageDriver
fun main() {
    val method: (String, String) -> Unit = { aStr, bStr -> println("a : $aStr, b:$bStr") }
    method("john","男")

    val method02 = { println("john")}
    val method03:(String)->Unit={
        println("传入的是:$it")
    }
    method03("Jon")
    val method04:(Int)->Unit={
        when(it){
            1-> println("等于1")
            in 20.. 30 -> println("20 - 30的数字")
            else -> println("都不满足")
        }
    }
    method04(1)
    val method05 : (Int,Int)-> Unit = {aNumber,bNumber->
        println("第一个: $aNumber, 第二个 : $bNumber")
    }
    method05(1,9)

    val method06 : (Int,Int)-> Unit = {aNumber,_->
        println("第一个: $aNumber")
    }
    method06(99,88)
    val method07 : (String)->String = {str -> str}
    println(method07("Jon"))
}