package anonyfunc

class Anony1 {
    companion object {
        fun sEnableDialog(block: () -> Unit) {
            block()
        }
    }
}



inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
