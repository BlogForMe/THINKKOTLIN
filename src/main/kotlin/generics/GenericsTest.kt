package generics

fun main() {
//    var list: MutableList<out Fruit> = ArrayList<Apple>() // ? extends Fruit 实际类型可能比是Apple小
////    list.add(Apple()) 编译报错
//    var list2: ArrayList<in Apple> = ArrayList<Fruit>() //  ? super Fruit  实际类型可能比是Apple大很多
////    list2.get(0)

    "".withMy("hehe"){
        println("当前值是 $this")
    }
}

public inline fun <T, R> String.withMy(receiver: T, block: T.() -> R): R = receiver.block()
