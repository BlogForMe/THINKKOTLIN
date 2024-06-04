package pattern.proxy.xiangxue;

public class ZhangYuXin implements  ZyxInterface {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello from zyx "+ name);
    }
}
