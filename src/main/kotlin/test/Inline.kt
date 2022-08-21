package test


fun hello(postAction: () -> Unit) {
    println("Hello!")
    postAction()
}

fun main() {
    hello {
        println("Bye")
    }
}