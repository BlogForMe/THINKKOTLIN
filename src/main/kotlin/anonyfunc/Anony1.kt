package anonyfunc

import `object`.Student
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class Anony1 {
    companion object {
        fun sEnableDialog(block: () -> Unit) {
            block()
        }
    }
}

fun main() {
//    Anony1.sEnableDialog { println("testing") }
//
//    val student = Student("JJ").apply {
//        score = 100
//    }
//
//    println(student)

//    val arrayListOf = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    arrayListOf?.forEach{
//       println(it%(5))
//    }

    val ss1 = arrayOf(
        "homepage.function.coachMark.title",
        "homepage.function.coachMark.content",
        "guide.next.title",
        "homepage.goplus.coachMark.title",
        "homepage.goplus.coachMark.content",
        "homepage.my_rewards.coachMark.title",
        "homepage.my_rewards.coachMark.content",
        "homepage.reload.coachMark.title",
        "homepage.reload.coachMark.content",
        "homepage.balance.coachMark.title",
        "homepage.balance.coachMark.content",
        "guide.got_it.title"
    )


//    println(5 shl 1)

    val ss2 = arrayOf(
        "homepage.allServices.edit.title",
        "homepage.allServices.coachMark.edit_title",
        "homepage.allServices.coachMark.edit_content",
        "homepage.allServices.manage_serivces.title",
        "homepage.allServices.search.placeholder",//clear
        "homepage.allServices.search.cancel",
        "homepage.allServices.search.tips",
        "homepage.allServices.searchHistory.title",
        "homepage.allServices.searchHistory.clear_all",
        "homepage.allServices.clear_keys.dialog_title",//dialog
        "homepage.allServices.clear_keys.dialog_content",
        "homepage.allServices.clear_keys.dialog_cancel",
        "homepage.allServices.clear_keys.dialog_clear"
    )
//    print(ss2)

    val editService = arrayOf(
        "homepage.allServices.edit_page.title",
        "homepage.allServices.edit_page.context",
        "homepage.allServices.edit_page.save",
        "homepage.allServices.edit_page.save_dialog_title",
        "homepage.allServices.edit_page.save_dialog_no",
        "homepage.allServices.edit_page.save_dialog_yes",
        "homepage.allServices.edit_page.full_dialog_title",
        "homepage.allServices.edit_page.full_dialog_content",
        "homepage.allServices.edit_page.full_dialog_ok"
    )

//    arrayOf("homepage.need_assistance.title").print()


    arrayOf(
        "homepage.allServices.edit_page.title",
        "homepage.allServices.edit_page.context",
        "homepage.allServices.edit_page.save",
        "homepage.allServices.edit_page.save_dialog_title",
        "homepage.allServices.edit_page.save_dialog_no",
        "homepage.allServices.edit_page.save_dialog_yes",
        "homepage.allServices.edit_page.full_dialog_title",
        "homepage.allServices.edit_page.full_dialog_content",
        "homepage.allServices.edit_page.full_dialog_ok"
    ).print()


}

fun  Array<String>.print() {
    this?.forEach {
        println("${it.replace(".", "_").uppercase()}  \"$it\"    ${it.replace(".", "_").lowercase()}  ")
    }
}


inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
