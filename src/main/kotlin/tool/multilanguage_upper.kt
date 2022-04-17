package tool


fun main() {

//    arrayOf(
//        "rfid.list.action.terminate.pending",
//        "rfid.list.action.terminate.now",
//        "rfid.list.action.activation.continue"
//    ).print()

//    arrayOf(
//        "rfid.list.termination.processing.title",
//        "rfid.list.termination.processing.message",
//        "rfid.list.termination.ok"
//    ).print()
    arrayOf(
        "rfid.termination.bar.title",
        "rfid.termination.tip.title",
        "rfid.termination.reason.placeholder",
        "rfid.termination.tip.warning",
        "rfid.termination.btn.submit"
    ).print()


}

fun Array<String>.print() {
    this?.forEach {
        println("${it.replace(".", "_").uppercase()}  \"$it\"    ${it.replace(".", "_").lowercase()}  ")
    }
}