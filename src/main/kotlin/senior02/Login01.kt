package senior02


fun main() {
    val loginModelImpl = LoginModelImpl()
    val responseModel = ResModel(0)
    loginModelImpl.loginOptions("", "", ::test) // 可以看到 fun test(resModel: ResModel)也被调用,可以理解被回调
//    loginModelImpl.loginOptions("","",{model: ResModel -> model.toString() })
//    loginModelImpl.loginOptions("","",{model -> model.toString() })
    loginModelImpl.loginOptions("", "", { println(it.int) }) //lambda只有一个参数，传入参数也可以省略,{}里面用it代替
//    loginModelImpl.loginOptions("","",{}) // it可以用也可以不用
}

//传入一个具名函数，被调用后，获取参数
fun test(resModel: ResModel) {
    println(resModel.int)
}

class LoginModelImpl {
    fun loginOptions(
        mobileNo: String,
        metaInfo: String,
        block: (model: ResModel) -> Unit
    ) {
        val model = ResModel(8)
//        block(model)
        block.invoke(model)     //这样写也可以
    }
}

class ResModel(val int: Int)