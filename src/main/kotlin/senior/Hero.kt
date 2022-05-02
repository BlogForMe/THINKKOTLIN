package senior

import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws

//
//fun main() {
//    val adversary = Jhava()
//    println(adversary.utterGreeting())
//
//    // determineFriends String! 平台类型
////    val level = adversary.determineFriends().toLong()
////    level?.toLong()
//    println(adversary.hitPoints)
//
//
//    try {
//        adversary.extendHandInFriendship()
//    } catch (e: Exception) {
//        println("exception")
//    }
//
//
//    try {
//        acceptApology()
//    } catch (e: IOException) {
//        println("exception")
//    }
//}
//
//fun makeProclamation() = "Greetings , beast!"


fun acceptApology() {
    throw IOException()
}

@Throws(IOException::class)
fun acceptApology1() {
    throw IOException()
}

//@file:JvmName("Hero")

//调用者可以指定英雄左手或右手拿什么食物，或者使用默认的配置 - 左手拿浆果，右手拿牛肉
@JvmOverloads
fun handoverFood(leftHand: String = "berries", rightHand: String = "beef") {
    println("Mmmm... you hand over some delicious $leftHand and $rightHand")
}

//添加一个translator的函数，接收一个字符串
//将其改为小写字面，再大写第一个字符，最后打印结构
var translator : (String)->Unit = { utterance: String ->
    println(utterance.toLowerCase().capitalize())
}
