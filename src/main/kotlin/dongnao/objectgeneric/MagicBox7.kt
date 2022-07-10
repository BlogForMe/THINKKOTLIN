package dongnao.objectgeneric

class MagicBox<T : Human>() { // 这里的T类型没用
    //随机产生一个对象，如果不是指定类型的对象，就通过backup函数生成一个指定类型的对象
//    fun <T> randomOrBackup(backup: () -> T): T {    // backup: ()->T 函数 和randomOrBackup返回的都是T类型
//          val items = listOf(Boy("jocnk", 20), Man("john", 20))
//          val random = items.shuffled().first()
//          return if (random is T) {
//              random
//          } else {
//              backup()
//          }
//      }

    //随机产生一个对象，如果不是指定类型T的对象，就通过backup函数生成一个指定类型T的对象
    // 根据传进来的Man对象类型，推断T类型为Man
    // backup: ()->T 函数 和randomOrBackup返回的都是T类型
    //inline  reified一起使用
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val items = listOf(Boy("jocnk", 20), Man("john", 20))
        val random = items.shuffled().first()
        println(random)
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}

fun main() {
    val box1: MagicBox<Man> = MagicBox() // 这里T类型不起作用
    // 由backup函数推断出来T的类型
    val subject = box1.randomOrBackup { Man("Jimmy", 28) }  //根据传进来的Man对象类型，推断T类型为Man
    println(subject)
}



