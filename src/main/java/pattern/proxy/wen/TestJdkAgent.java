package pattern.proxy.wen;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkAgent {
    public static void main(String[] args) {


        /**
         * 方式1
         */
        ProxyDog proxyDog = new ProxyDog(new InvocationHandler() {
            @Override
            public void invoke() {
                //enhancement feature
                System.out.println("before");
                new TargetDog().eat();
            }
        });
        proxyDog.eat();
        proxyDog.drink();  //从这里看，没法区分是eat() 还是 drink()


        /**
         * 方式2
         */
        Target proxy = (Target) Proxy.newProxyInstance(TestJdkAgent.class.getClassLoader(), new TargetDog().getClass().getInterfaces(), new java.lang.reflect.InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //1. 前置增强逻辑
                System.out.println("before...");
                /**
                 * 2. 目标对象的原始方法
                 * 目标对象，方法
                 */
                Object obj = method.invoke(new TargetDog(), args);
                return obj;
            }
        });
        proxy.eat();
    }

}

interface Target {
    void eat();

    void drink();
}


class TargetDog implements Target {

    @Override
    public void eat() {
        System.out.println("eat shit");
    }

    @Override
    public void drink() {
        System.out.println("drink");
    }
}


interface InvocationHandler {
    void invoke();
}





