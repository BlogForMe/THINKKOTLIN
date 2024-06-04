package pattern.proxy.xiangxue;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DoSomeThingDynamic {
    Object object;

    public DoSomeThingDynamic(Object object) {
        this.object = object;
    }

    /**
     * @param say 需要代理执行的接口类
     * @param <T>
     * @return 动态代理 运行时生成的一个say对应类型的类，用于调用say接口的时候 运行
     */
    public <T> T create(final Class<T> say) {
        return (T) Proxy.newProxyInstance(say.getClassLoader(),
                new Class<?>[]{say},
                new InvocationHandler() {
                    /**
                     * invoke方法:  代理类 BinInterface$0 调用super.h.invoke(this, m3, new Object[]{var1});就会调用到
                     * Object o : 代表生成的new BinInterface$0()对象，
                     * Method method : 代理类调用的方法，把方法传进来。
                     * Object[] args ： 方法的参数
                     */
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        System.out.println("拍电影前的准备工作");
                        /**
                         *  method这个函数是 反射的函数
                         *
                         * 等价于 zhangYuXin.sayHello();
                         * similar to
                         * object.method(arg)
                         *
                         * object 是目标类，也就是 new zhangYuXin()
                         * 下面object 不能用invoke(Object o)中的参数o替代。
                         */
                        Object result = method.invoke(object, args);
                        System.out.println("拍电影后的收尾工作");
                        return result;
                    }
                }
        );
    }
}
