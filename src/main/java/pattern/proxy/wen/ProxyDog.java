package pattern.proxy.wen;

import java.lang.reflect.Method;

public class ProxyDog implements Target {

    InvocationHandler h;

    public ProxyDog(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void eat() {
        try {
            Method eat = Target.class.getMethod("eat");
            h.invoke(eat, new Object[0]);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void drink() {
        try {
            Method drink = Target.class.getMethod("drink");
            h.invoke(drink, new Object[0]);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
