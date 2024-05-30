package test


interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b   // kotlin这里自动生成了java代理中 ZhangYuXinProxy
