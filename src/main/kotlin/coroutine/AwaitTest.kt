package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.selects.select
import kotlin.system.measureTimeMillis


suspend fun main() {
//    select01()
//    testSelectAwait()
//    select02()
//    testSelect4()

//    testChannelSendSelect()
//    testFlowMerge()


    val measureTimeMillis = measureTimeMillis {
//        flowTest()
        testFlow()
    }
    println("measureTimeMillis $measureTimeMillis")


}

fun testFlow() = runBlocking {
    val name = "guest"
    coroutineScope {
        listOf(::getUserFromLocal, ::getUserFromNetwork)
            .map { function -> function.call() }
            .map { deferred ->
                flow { emit(deferred.await()) }
            }.merge().collect { user -> println(user) }
    } //这个没问题，可以用,   4秒


}

suspend fun flowTest() {

    flow<Int> {
        // 向下游发射100
        emit(doRemote())
        emit(doLocal())
    }.collect {
        println("output $it")
    }
}

suspend fun select02() {
//    https://juejin.cn/post/7041835887897870373
    val channels = listOf(Channel<Int>(), Channel<Int>())
    GlobalScope.launch {
        delay(100)
        channels[0].send(200)
    }

    GlobalScope.launch {
        delay(50)
        channels[1].send(100)
    }

    val result = select<Int?> {
        channels.forEach { channel ->
            channel.onReceive { it }
        }
    }
    println(result)
}

suspend fun select01() {
    GlobalScope.launch {
        val doRemote = async(Dispatchers.IO) { doRemote() }
        val doLocal = async(Dispatchers.IO) { doLocal() }
//        println("doremote ${doRemote.await()}")
//        println("doLocal ${doLocal.await()}")

        println("total result")
//        val response = select<Int> {
//            doRemote.onAwait{it} // 别忘了 {it}
//            doLocal.onAwait{it}
//        }
//        println("response $response")
    }.join()
}


private suspend fun doRemote(): Int {
    delay(5000)
    println("doOne")
    return 14
}

private suspend fun doLocal(): Int {
    delay(6000)
    println("doTwo")
    return 25
}


fun testSelectAwait() = runBlocking {
    GlobalScope.launch {
        val userFromLocal = getUserFromLocal()
        val userFromNetwork = getUserFromNetwork()
        val select = select<String> {
            userFromLocal.onAwait { it }
            userFromNetwork.onAwait { it }
        }
        println(select)
    }.join()
}

//作者：yunboAndroid
//链接：https://juejin.cn/post/7044783808385646606
//来源：稀土掘金
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


fun testSelect4() {
    runBlocking {
        val bitmap = null;
        val starTime = System.currentTimeMillis()
        val receiveChannelZxing = produce {
            //生产数据
            val result = getQrcodeInfoFromZxing()
            //发送数据
            send(result)
        }

        val receiveChannelZbar = produce {
            val result = getQrcodeInfoFromZbar()
            send(result)
        }

        val result = select<String> {
            //监听是否有数据发送过来
            receiveChannelZxing.onReceive { value ->
                "zxing result $value"
            }

            receiveChannelZbar.onReceive { value ->
                "zbar result $value"
            }
        }

        println("result from $result useTime:${System.currentTimeMillis() - starTime}")
    }
}

private fun getQrcodeInfoFromZxing() = "FromZxing"
private fun getQrcodeInfoFromZbar() = "FromZbar"

fun testChannelSendSelect() = runBlocking {
    val channels = listOf(Channel<Int>(), Channel<Int>())
    launch {
        select<Unit?> {
            launch {
                delay(100)
                channels[0].onSend(0) {
                    println("onSend 0")
                }
            }

            launch {
                delay(50)
                channels[1].onSend(1) {
                    println("onSend 1")
                }
            }
        }
    }

    GlobalScope.launch {
        println(channels[0].receive())
    }

    GlobalScope.launch {
        println(channels[1].receive())
    }

}

fun testFlowMerge() = runBlocking {
    GlobalScope.launch {
        val userFromLocal = getUserFromLocal()
        val userFromNetwork = getUserFromNetwork()
        val select = select<String> {
            userFromLocal.onAwait { it }
            userFromNetwork.onAwait { it }
        }
        println(select)
    }.join()
}

//作者：yunboAndroid
//链接：https://juejin.cn/post/7044783808385646606
//来源：稀土掘金
//著作权归作者所有。商业转载请联系作者获得授权，非商业转

fun CoroutineScope.getUserFromLocal() = async(Dispatchers.IO) {
    // 模拟读取本地数据
    delay(3000)
    "getUserFromLocal"
}

fun CoroutineScope.getUserFromNetwork() = async(Dispatchers.IO) {
    // 模拟读取网络数据
    delay(6000)
    "getUserFromNetwork"
}
