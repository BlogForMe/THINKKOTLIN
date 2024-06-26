package pattern.proxy.xiangxue;

public class ZhangYuXinProxy implements ZyxInterface {
    private ZhangYuXin zhangYuXin;

    public ZhangYuXinProxy(ZhangYuXin zhangYuXin) {
        this.zhangYuXin = zhangYuXin;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("拍电影前的准备工作");
        zhangYuXin.sayHello(name);
        System.out.println("拍电影后的收尾工作");
    }
}
