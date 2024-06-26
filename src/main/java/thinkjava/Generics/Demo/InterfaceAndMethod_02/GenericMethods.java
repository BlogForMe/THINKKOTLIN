package thinkjava.Generics.Demo.InterfaceAndMethod_02;

/**
 * Created by Jon on 2016/6/2.
 * 15.4 泛型方法
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
