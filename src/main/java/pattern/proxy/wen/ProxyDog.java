package pattern.proxy.wen;

public class ProxyDog  implements Target{

    InvocationHandler h;

    public ProxyDog(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void eat() {
        h.invoke();
    }

    @Override
    public void drink() {

    }
}
