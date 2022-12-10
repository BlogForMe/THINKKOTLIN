package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() {
    println("te")

}

fun `test combine select`() = runBlocking {

//        println("completed in $time ms")
}


private suspend fun doRemote(): Int {
    delay(2000)
    println("doOne")
    return 14
}

private suspend fun doLocal(): Int {
    delay(1000)
    println("doTwo")
    return 25
}