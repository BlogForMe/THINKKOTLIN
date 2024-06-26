package thinkjava.Generics.Demo.Qustion_05;

/**
 * Created by Administrator on 2017/1/16.
 */
public class NotSelfBounded<T> {
    T element;

    NotSelfBounded<T> set(T arg) {
        this.element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A2 extends NotSelfBounded<A2> {
}

class B2 extends NotSelfBounded<A2> {
}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) {
        set(arg);
        return get();
    }
}

class D2 {
}

class E2 extends NotSelfBounded<D2> {
}
