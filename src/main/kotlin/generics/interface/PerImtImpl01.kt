package generics.`interface`

class PerImtImpl01<T> : PerInt<T> {
    var name: T
        get() {
            return name
        }
        set(value) {
            name = value
        }

    override fun show(name: T) {
    }

    fun show(p: PerImtImpl01<*>) { //如果是T类型 编译报错，虽然Int:Number,但是在泛型中不存在继承关系
        name = p.name as T
    }
}