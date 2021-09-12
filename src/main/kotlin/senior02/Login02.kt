package senior02
// https://www.bilibili.com/video/BV1xv411k7Dd?p=3&spm_id_from=pageDriver
fun main() {
    loginAction("Jo1n", "123456") {
        if (it) {
            println("登录成功")
        } else
            println("登录失败")
    }
}

fun loginAction(userName: String, pwd: String, loginResponseResult: (Boolean) -> Unit) {
    if (userName == null || pwd == null) return
    loginEngine(userName, pwd, loginResponseResult)
}

fun loginEngine(userName: String, pwd: String, loginResponseResult: (Boolean) -> Unit) {
    if ("Jon" == userName && "123456" == pwd) {
        loginResponseResult(true)
    } else
        loginResponseResult(false)
}
