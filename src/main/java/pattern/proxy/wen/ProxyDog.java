package pattern.proxy.wen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDog implements Target {

    InvocationHandler h;


    public ProxyDog(InvocationHandler h) {
        this.h = h;
    }

    static Method eat;
    static Method drink;

    static {
        try {
            eat = Target.class.getMethod("eat");
            drink = Target.class.getMethod("drink");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eat() {
        try {
            h.invoke(this,eat, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void drink() {
        try {
            h.invoke(this,drink, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
